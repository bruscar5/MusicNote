import java.util.Scanner;

public class MeasureTest {
    public static void main (String [] args) {
        Measure yay = new Measure();
        String duration = "";
        boolean loop = true;
        boolean rep;
        String repeat;
        Rest rest = new Rest();

        while (loop) {
            Scanner kb = new Scanner(System.in);
            System.out.println("Please enter a note(ex: 'C4'): ");
            String note = kb.nextLine();
            System.out.println("Please enter a duration for that note: ");
            try {
                System.out.printf("%-10s%-10s\n%-10s%-10s%-10s\n", "'w' - whole note", "|'h' - half note|", "'q' - quarter note|", "'e'-eigth note|", "'s' - sixteenth note");
                duration = kb.nextLine();
                if (!(duration.equalsIgnoreCase("w") ||duration.equalsIgnoreCase("h") || duration.equalsIgnoreCase("q") || duration.equalsIgnoreCase("e") || duration.equalsIgnoreCase("s"))) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {System.out.println("Invalid input. Please choose: ");
            }
            //MusicNote a = new MusicNote(note, duration);
            if (note.equalsIgnoreCase("r")) {
                yay.addNote(rest, duration);
            } else {
                yay.addNote(note, duration);
            }
            System.out.println(yay.toString());
            System.out.println(1 - yay.getMeasureFilled() + " measure filled");
            System.out.println(yay.getMeasureFilled() + "measure left.");
            System.out.println("Enter another note? Enter y to continue, anything else to quit: ");
            String input = kb.nextLine();
            if (!(input.equalsIgnoreCase("y"))) {
                loop = false;
            }
        }
    }
}