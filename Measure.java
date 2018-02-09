import java.util.*;

public class Measure {
    private static final double sixteenthNote = (1.0/16.0);
    private static final double eigthNote = (1.0/8.0);
    private static final double quarterNote = (1.0/4.0);
    private static final double halfNote = (1.0/2.0);
    private static final double wholeNote = (1.0);
    int numNotes = 0;
    private Note[] measure;
    private double measureFilled = 1.0;

    public Measure() {
        measure = new MusicNote[16];
    }

    public static double timeToDouble(String time) {
        boolean loop = true;
        while (loop) {
            try {
                if (time.equals("w")) {
                    loop = false;
                    return wholeNote;
                }
                else if (time.equals("h")) {
                    loop = false;
                    return halfNote;
                }
                else if (time.equals("q")) {
                    loop = false;
                    return quarterNote;
                }
                else if (time.equals("e")) {
                    loop = false;
                    return eigthNote;
                }
                else if (time.equals("s")) {
                    loop = false;
                    return sixteenthNote;
                }
                else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {System.out.println("INVALID!! Please enter a valid character: ");
                Scanner kb = new Scanner(System.in);
                time = kb.nextLine();
            }
        }
        return 0.0;
    }

    public static String timeToString(Double time) {
        boolean loop = true;
        while (loop) {
            try {
                if (time == (1.0)) {
                    loop = false;
                    return "w";

                }
                else if (time == (1.0/2.0)) {
                    loop = false;
                    return "h";

                }
                else if (time == (1.0/4.0)) {
                    loop = false;
                    return "q";

                }
                else if (time == (1.0/8.0)) {
                    loop = false;
                    return "e";

                }
                else if (time == (1.0/16.0)) {
                    loop = false;
                    return "s";

                }
                else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Program encountered a fatal error.");
                return null;
            }
        }
        return null;
    }

    public void addNote(String note, boolean repeat, double time) {

        boolean measureFull = true;
        while (measureFull) {

            try {
                measureFilled = measureFilled - time;
                //System.out.println("Loop!");
                if (measureFilled < 0) {
                    measureFilled = measureFilled + time;
                    throw new IllegalArgumentException();
                }
                MusicNote a = new MusicNote(note, Measure.timeToString(time));
                measure[numNotes] = a;
                numNotes = numNotes + 1;
                measureFull = false;
            } catch (IllegalArgumentException e) {
                System.out.println("Measure filled.");
                return;
            }
        }
    }

    public void addNote(MusicNote note) {

        boolean measureFull = true;
        while (measureFull) {

            try {
                measureFilled = measureFilled - Measure.timeToDouble(Character.toString(note.getDuration()));
                //System.out.println("Loop!");
                if (measureFilled < 0) {
                    measureFilled = measureFilled + Measure.timeToDouble(Character.toString(note.getDuration()));
                    throw new IllegalArgumentException();
                }
                MusicNote a = new MusicNote(note.toString(), note.getDuration(), note.getRepeat());
                measure[numNotes] = a;
                numNotes = numNotes + 1;
                measureFull = false;

            } catch (IllegalArgumentException e) {
                System.out.println("Measure filled.");
                return;
            }
        }
    }

    public void addNote(Rest rest, String time) {

        try {
            if (measureFilled - Measure.timeToDouble(time) < 0) {
                throw new IllegalArgumentException();
            }
            Rest a = new Rest();
            char dur = time.charAt(0);
            a.setDuration(dur);
            measureFilled = measureFilled - Measure.timeToDouble(time);
            measure[numNotes] = a;
            numNotes = numNotes + 1;

        } catch (IllegalArgumentException e) {
            System.out.println("Measure filled");
            return;
        }

    }
    
    public void addNote(Rest rest,boolean repeat, String time) {
        boolean loop = true;
        while (loop) {
        try {
            if (measureFilled - Measure.timeToDouble(time) < 0) {
                throw new IllegalArgumentException();
            }
            Rest a = new Rest();
            char dur = time.charAt(0);
            a.setDuration(dur);
            a.setRepeat(repeat);
            measureFilled = measureFilled - Measure.timeToDouble(time);
            measure[numNotes] = a;
            numNotes = numNotes + 1;
            loop = false;
        } catch (IllegalArgumentException e) {
            System.out.println("Measure filled");
            return;
        }
    }
    }

    public void addNote(String note, String time) {

        try {
            if (measureFilled - Measure.timeToDouble(time) < 0) {
                throw new IllegalArgumentException();
            }
            MusicNote a = new MusicNote(note, time);
            char dur = time.charAt(0);
            a.setDuration(dur);
            measureFilled = measureFilled - Measure.timeToDouble(time);
            measure[numNotes] = a;
            //System.out.println(numNotes);
            //System.out.println(measure[numNotes].toString());
            numNotes = numNotes + 1;

        } catch (IllegalArgumentException e) {
            System.out.println("Measure filled");
            return;
        }

    }

    public Note[] getMeasure() {
        return measure;
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < measure.length && measure[i] != null; i++) {
            //System.out.println("numNotes: " + numNotes);
            //System.out.println(measure.length);
            if (measure[i] != null) {
                output = output.concat(measure[i].toString() + " ");
            }
        }
        return output;
    } 

    public int getNumNotes() {
        return numNotes;
    }

    public double getMeasureFilled() {
        return measureFilled;
    }
    
    public boolean isEmpty() {
        for (int i = 0; i < measure.length; i++) {
            if (measure[i] != null) {
                return false;
            }
        }
        return true;
    }

}