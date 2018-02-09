import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

public class Song {
    private Stack<Measure> song = new Stack<Measure>();
    private Stack<Measure> songHolder = new Stack<Measure>();
    int numMeasures = 0;
    private Pattern notePattern = Pattern.compile("\\w\\w"); //pattern compiled for scanner to find note
    private Pattern durationPattern = Pattern.compile("[a-z&&[ehqsw]]"); //pattern compiled for scanner to find duration value
    private Pattern falseBooleanPattern = Pattern.compile("\\w\\w\\w\\w\\w"); //pattern for false repeat values
    private Pattern trueBooleanPattern = Pattern.compile("\\w\\w\\w\\w"); //pattern for true repeat values
    private Pattern restPattern = Pattern.compile("\\w"); // pattern for rest values
    Rest compare = new Rest();
    private Heap<Note> noteTree = new Heap<Note>();

    public Song() {
        //numMeasures = numMeasures + 1;
        //Measure firstMeasure = new Measure();
        //song.add(firstMeasure);
    }

    public Song(String fileName) { // song constructor for creating a song from a file
        this.readFile(fileName);
    }

    public void addMeasure(Measure a, boolean repeat) {
        song.add(a);
        //repeatedSections.add(repeat);
        numMeasures = numMeasures + 1;
    }

    public void addNote(String a, boolean repeat, String duration) { //adds a note to the song
        if (numMeasures > 0) { //if measure exists, method proceeds to check if it's filled
            Measure current = song.pop(); //
            if (current.getMeasureFilled() - Measure.timeToDouble(duration) >= 0) { //if measure isn't full and new value won't
                //overfill it
                if (a.equalsIgnoreCase("r")) {
                    Rest r = new Rest(a, repeat, duration);
                    current.addNote(r);
                } else {
                    current.addNote(a, repeat, Measure.timeToDouble(duration)); //add note to measure

                }
                System.out.println("Adding note. . .");
                System.out.println("Current measure: " + current.toString());
                song.add(current); //add measure back to song

            } else { //if measure full or added value will overfill measure
                Measure current2 = new Measure(); //create new measure
                if (a.equalsIgnoreCase("r")) {
                    Rest r = new Rest(a, repeat, duration);
                    current2.addNote(r);
                } else {
                    current2.addNote(a, repeat, Measure.timeToDouble(duration)); //add note to measure
                }
                System.out.println("Adding note. . .");
                System.out.println("Current measure: " + current2.toString());
                song.add(current); //add original measure back to song
                song.add(current2); //add new measure to song
                numMeasures = numMeasures + 1; //increment measures by one

            }
        } else {
            Measure current = new Measure(); //if no measures exist, create measure
            if (a.equalsIgnoreCase("r")) {
                Rest r = new Rest(a, repeat, duration);
                current.addNote(r);
                //System.out.println("1");
            } else {
                current.addNote(a, repeat, Measure.timeToDouble(duration)); //add note to measure
            }
            System.out.println("Adding note. . .");
            System.out.println("Current measure: " + current);
            song.add(current); //add measure to song
            numMeasures = numMeasures + 1; //increment measures

        }
    }

    public String toString() {
        String output = "";
        Measure currentMeasure = new Measure();
        //currentMeasure = song.pop();
        //System.out.println(currentMeasure.toString());
        //song.add(currentMeasure);
        int count = numMeasures; //count set to numMeasures, is number of times method below is repeated
        int numNotes = this.getNumNotes(); //total number of notes in the songs
        while (!(song.isEmpty())) {
            songHolder.add(song.pop());
        }
        while (!(songHolder.isEmpty())) {
            currentMeasure = songHolder.pop();
            //System.out.println(currentMeasure.toString());
            //output.concat(currentMeasure.toString()); //pops off first measure
            Note [] notes = currentMeasure.getMeasure(); //gets array of notes from measure
            //System.out.println(currentMeasure.getNumNotes());
            for (int i = 0; i < currentMeasure.getNumNotes(); i++) { //increments through this measure until it hits a void value in array or it reaches array's length
                //System.out.println(notes[i].toString());
                if (notes[i].getRepeat()) { //if note repeats (saved as boolean instance variable)
                    i = i + 1;
                    while (!(notes[i].getRepeat())) { //until another true statement ends the repeated section, 
                        if (i < notes.length) { //Check to see if measure still has notes
                            output = output.concat(notes[i].toString() + " "); //add note to String
                            output = output.concat(notes[i].toString() + " "); //repeat note
                            i = i + 1;
                        }
                        else {
                            song.add(currentMeasure); //add the completed measure back to the song
                            currentMeasure = songHolder.pop(); //remove the next measure to be added
                            notes = currentMeasure.getMeasure(); //get array of note objects
                            i = 0; //reset i for new measure
                        }//if measure has been completed and end of repeated section still not found
                    }

                } else { //if notes do not repeat
                    output = output.concat(notes[i].toString() + " "); //concatonate note to string
                }
            }
            song.add(currentMeasure); //add current measure back to song
            count = count - 1; //decrement the count

        }
        while (!(songHolder.isEmpty())) {
            song.add(songHolder.pop());
        }
        return output;
    }

    /*The method below returns a string that reverses this song's notes
     * Uses a queue and a stack to reverse the output order
     */
    public String reverseSong() {
        String output = "";
        Measure currentMeasure = new Measure();
        Queue<Measure> reverseSong = new LinkedList<Measure>();
        int count = numMeasures; 
        int numNotes = this.getNumNotes(); 
        while (!(song.isEmpty())) {
            reverseSong.add(song.pop());
        }
        while (!(reverseSong.isEmpty())) {
            currentMeasure = reverseSong.remove();
            Note [] notes = currentMeasure.getMeasure(); 
            for (int i = 0; i < currentMeasure.getNumNotes(); i++) { 
                if (notes[i].getRepeat()) { 
                    i = i + 1;
                    while (!(notes[i].getRepeat())) {  
                        if (i < notes.length) { 
                            output = output.concat(notes[i].toString() + " "); 
                            output = output.concat(notes[i].toString() + " "); 
                            i = i + 1;
                        }
                        else {
                            song.add(currentMeasure); 
                            currentMeasure = reverseSong.remove(); 
                            notes = currentMeasure.getMeasure(); 
                            i = 0; 
                        }
                    }

                } else { //if notes do not repeat
                    output = output.concat(notes[i].toString() + " "); 
                    if (output.length() > notes.length * 4) {
                        output = output.concat("\n"); 
                    }
                }
            }
            song.add(currentMeasure); 

        }
        while (!(reverseSong.isEmpty())) {
            song.add(reverseSong.remove());
        }
        return output;
    }

    public void readFile(String fileName) {
        Scanner inputReader = new Scanner(System.in); //new scanner!
        boolean loop = true; //loop for enclosing the try catch block
        String note = ""; //note for holding the strPitch value
        String duration = ""; //duration for holding duration value
        String repeats = "";
        boolean repeat = false; //repeat value to be passed to MusicNote object

        while (loop) {
            try {
                FileInputStream kb = new FileInputStream(fileName); //new input file stream to read data from file
                Scanner reader = new Scanner(kb); //initialize scanner object to read file
                Measure fileMeasure = new Measure(); //creates a measure to add notes to
                while (reader.hasNext()) {
                    /*if (fileMeasure.getMeasureFilled() <= 0) { //if measure is full
                    System.out.println("This should not be first");
                    song.add(fileMeasure); //add measure to song
                    fileMeasure = new Measure(); //initialize new measure and assign it to fileMeasure
                    numMeasures = numMeasures + 1; //increment number of measures
                    } */
                    note = reader.findInLine(notePattern); //scanner looks for note pattern in line and assigns it to string note
                    //System.out.println(note);
                    duration = reader.findInLine(durationPattern); //scanner looks for duration pattern in line and assigns it to string duration
                    //System.out.println(duration);
                    //System.out.println(Measure.timeToDouble(duration));
                    //System.out.print(note + " " + duration);
                    if (reader.hasNext("true")) { //if next value is true
                        reader.next();
                        //System.out.println("true");
                        repeat = true; //repeat is true
                        //System.out.println(" true");
                    } else { //if it isn't true
                        if (reader.hasNext("false")) {
                            reader.next(); //move scanner forward
                        }
                        //System.out.println("false");
                        repeat = false; //repeat is false
                        //System.out.println(" false");
                        //System.out.println("Working");
                    }

                    //System.out.println(fileMeasure.getMeasureFilled());
                    if (fileMeasure.getMeasureFilled() - Measure.timeToDouble(duration) <= 0) { //if duration will cause a measure overflow, new measure
                        //System.out.println(fileMeasure.toString() + "Added to song.");
                        song.add(fileMeasure);
                        fileMeasure = new Measure();
                        MusicNote fileNote = new MusicNote(note, duration.charAt(0), repeat);
                        fileMeasure.addNote(fileNote); //add note to measure
                        numMeasures = numMeasures + 1;
                    } else {
                        MusicNote fileNote = new MusicNote(note, duration.charAt(0), repeat); //create note
                        //System.out.println("note: " + fileNote.toString());
                        // System.out.println("Duration: " + duration.charAt(0));
                        // System.out.println("Repeat" + repeat);
                        fileMeasure.addNote(fileNote); //add note to measure
                        System.out.println("Measure " + numMeasures + ": " + fileMeasure.toString());
                    }

                    if (reader.hasNextLine()) //if statement prevents exception from being thrown
                     reader.nextLine();

                }
                //System.out.println("Escaped loop 1!");
                if (!(fileMeasure.isEmpty())) {
                    song.add(fileMeasure);
                }
                loop = false;
            } catch (FileNotFoundException e) { //exception catched!
                System.out.println("File not found. Please enter an existing filename: "); //loop lets user keep trying until file correctly entered
                fileName = inputReader.nextLine();
            }
        }
    }

    public double getLength() {
        double seconds = 0; //seconds of song
        Measure current; 
        while (!(song.isEmpty())) {
            songHolder.add(song.pop());
        }
        while (!(songHolder.isEmpty())) { //for number of measures
            current = songHolder.pop(); //current gets first measure of song
            if (current.getMeasureFilled() > 0) { //if measure not filled
                seconds = seconds + (1 - current.getMeasureFilled()); //add current time to time of measure
            } else { 
                seconds = seconds + 1; //else, if measure filled, just add 1 second
            }
            song.add(current); //add measure back to queue
        }
        return seconds;
    }

    public void changeTempo(double tempo) {
        Queue <Measure> otherSong = new LinkedList<Measure>();
        Measure current = new Measure();
        Note [] notes;
        double duration;
        String durationString;
        while (!(song.isEmpty())) {
            otherSong.add(song.pop());
        }
        while (!(otherSong.isEmpty())) {
            current = otherSong.remove();
            notes = current.getMeasure();
            for (int i = 0; (notes[i] != null) && (i < notes.length) ; i++) {
                duration = Measure.timeToDouble(Character.toString(notes[i].getDuration()));
                duration = duration * tempo;
                //System.out.println(duration);
                durationString = Measure.timeToString(duration);
                notes[i].setDuration(durationString.charAt(0));
            }
            song.add(current);
        }
    }

    public String append() {
        Scanner kb = new Scanner(System.in);
        String fileName;
        System.out.print("Please enter a filename to append to song: ");

        fileName = kb.nextLine();
        Song other = new Song(fileName);

        Queue <Measure> otherSong = new LinkedList<Measure>();
        while(!(other.song.isEmpty())) {
            otherSong.add(other.song.pop());
        }
        while (!(otherSong.isEmpty())) {
            this.song.add(otherSong.remove());
        }
        return "Song appended.";
    }

    /*
     * EXTRA CREDIT METHOD
     * Writes song to file
     */
    public void writeToFile(String fileName) {
        String input;
        boolean loop = true;
        Scanner kb = new Scanner(System.in);
        Measure currentMeasure = new Measure();
        while (loop) {
            try {
                input = fileName;
                FileWriter out = new FileWriter(input, true);
                while (!(song.isEmpty())) {
                    songHolder.add(song.pop());
                }
                while (!(songHolder.isEmpty())) {
                    currentMeasure = songHolder.pop();
                    //System.out.println(currentMeasure.toString());
                    //output.concat(currentMeasure.toString()); //pops off first measure
                    Note [] notes = currentMeasure.getMeasure(); //gets array of notes from measure
                    //System.out.println(currentMeasure.getNumNotes());
                    for (int i = 0; i < currentMeasure.getNumNotes(); i++) { //increments through this measure until it hits a void value in array or it reaches array's length
                        //System.out.println(notes[i].toString());
                        if (notes[i].getRepeat()) { //if note repeats (saved as boolean instance variable)
                            i = i + 1;
                            while (!(notes[i].getRepeat())) { //until another true statement ends the repeated section, 
                                if (i < notes.length) { //Check to see if measure still has notes
                                    out.write(notes[i].toString() + " "); //add note to String
                                    out.write(notes[i].toString() + " "); //repeat note
                                    i = i + 1;
                                }
                                else {
                                    song.add(currentMeasure); //add the completed measure back to the song
                                    currentMeasure = songHolder.pop(); //remove the next measure to be added
                                    notes = currentMeasure.getMeasure(); //get array of note objects
                                    i = 0; //reset i for new measure
                                }//if measure has been completed and end of repeated section still not found
                            }

                        } else { //if notes do not repeat
                            out.write(notes[i].toString() + " "); //concatonate note to string
                        }
                    }
                    song.add(currentMeasure); //add current measure back to song
                    loop = false;
                }
                out.close();
                return;
            } catch (IOException e) {
                System.out.println("Unable to write file. Please try again: ");
                fileName = kb.nextLine();
            }
        }
    }

    /*
     * EXTRA CREDIT METHOD: Counts measures
     */
    public int countMeasures() {
        return numMeasures;
    }

    public int getNumNotes() {
        int totalNumNotes = 0;
        Measure current;
        while (!(song.isEmpty())) {
            songHolder.add(song.pop());
        }
        for (int i = 0; i < numMeasures; i++) {
            current = songHolder.pop();
            totalNumNotes = current.getNumNotes();
            song.add(current);
        }
        return totalNumNotes;
    }

    public boolean hasNote() {
        if (!(song.isEmpty())) {
            return true;
        } else {return false;}
    }

    public void makeHeap(String fileName) {
        this.readFile(fileName);
        Note[] measureNotes;
        while (!(song.isEmpty())) {
            songHolder.add(song.pop());
        }
        while (!(songHolder.isEmpty())) {
            Measure current = songHolder.pop();
            measureNotes = current.getMeasure();
            for (int i = 0; measureNotes[i] != null && i < measureNotes.length; i++) {
                noteTree.addEntry(measureNotes[i]);
            }
            song.add(current);
        }
    }
}