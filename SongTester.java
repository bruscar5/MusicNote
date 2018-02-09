import java.util.Scanner;
import java.util.InputMismatchException;

public class SongTester {
    public static void main(String [] args) {
        String userResponse;
        Scanner input = new Scanner(System.in);
        Song melody = new Song();
        Song melody2 = new Song();
        double tempoChange;
        String note;
        String repeat;
        String duration;
        boolean rep;
        boolean loop = true;

        do{
            PrintMenu.printMenu();
            userResponse = input.nextLine();
            if (userResponse.equalsIgnoreCase("A")) {
                do {
                    PrintMenu.printNewSongSubMenu();
                    userResponse = input.nextLine();
                    if (userResponse.equalsIgnoreCase("A")) {
                        PrintMenu.printAddNoteMenu();
                        System.out.print("NOTE: ");
                        note = input.nextLine();
                        System.out.print(" REPEAT(y or n): ");
                        repeat = input.nextLine();
                        if (repeat.equalsIgnoreCase("y"))
                            rep = true;
                        else
                            rep = false;
                        System.out.print(" DURATION(w/h/q/e/s): ");
                        duration = input.nextLine();

                        melody.addNote(note, rep, duration);
                    }
                    else if (userResponse.equalsIgnoreCase("B")) {
                        System.out.println(melody.getLength() + " seconds");
                    } else if (userResponse.equalsIgnoreCase("C")) {
                        System.out.println(melody.reverseSong());
                    } 
                    else if (userResponse.equalsIgnoreCase("D")) {
                        try {
                            if (melody.hasNote()) {
                                System.out.println(melody.toString());
                            }  else {
                                throw new IllegalArgumentException();
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("!!!!!Song is empty. Error has occured. Please try again.!!!!!!");
                        } 
                    } else if (userResponse.equalsIgnoreCase("E")) {
                        System.out.print("Please enter file name: ");
                        userResponse = input.nextLine();
                        melody.writeToFile(userResponse);
                    } else if (userResponse.equalsIgnoreCase("F")) {
                        System.out.print("Enter a multiple by which you'd like to change the tempo: ");
                        loop = true;
                        while (loop) {
                            try {
                                tempoChange = input.nextDouble();
                                melody.changeTempo(tempoChange);
                                loop = false;
                            } catch (InputMismatchException e) {
                                System.out.print("\nPlease enter a number: ");
                            }
                        }
                    } else if (userResponse.equalsIgnoreCase("G")) {
                        System.out.println(melody.append());
                    }

                } while (!(userResponse.equalsIgnoreCase("H")));
            } else if (userResponse.equalsIgnoreCase("B")) {
                do {
                    PrintMenu.printFileSongSubMenu();
                    userResponse = input.nextLine();
                    if (userResponse.equalsIgnoreCase("A")) {
                        System.out.print("Please enter file name: ");
                        userResponse = input.nextLine();
                        melody = new Song(userResponse);
                    }
                    else if (userResponse.equalsIgnoreCase("B")) {
                        try {
                            if (melody.hasNote()) {
                                System.out.println(melody.toString());
                            }  else {
                                throw new IllegalArgumentException();
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("!!!!!Song is empty. Error has occured. Please try again.!!!!!!");
                        } 
                    }
                    else if (userResponse.equalsIgnoreCase("C")) {

                        PrintMenu.printAddNoteMenu();
                        System.out.print("NOTE: ");
                        note = input.nextLine();
                        System.out.print(" REPEAT(y or n): ");
                        repeat = input.nextLine();
                        if (repeat.equalsIgnoreCase("y"))
                            rep = true;
                        else
                            rep = false;
                        System.out.print(" DURATION(w/h/q/e/s): ");
                        duration = input.nextLine();
                        melody.addNote(note, rep, duration);

                    } else if (userResponse.equalsIgnoreCase("D")) {
                        System.out.println(melody.getLength());
                    } else if (userResponse.equalsIgnoreCase("E")) {
                        System.out.println(melody.reverseSong());
                    } else if (userResponse.equalsIgnoreCase("F")) {
                        System.out.print("Enter a multiple by which you'd like to change the tempo: ");
                        loop = true;
                        while (loop) {
                            try {
                                tempoChange = input.nextDouble();
                                melody.changeTempo(tempoChange);
                                loop = false;
                            } catch (InputMismatchException e) {
                                System.out.print("\nPlease enter a number: ");
                            }
                        }
                    } else if (userResponse.equalsIgnoreCase("G")) {
                        System.out.print("Please enter file name: ");
                        userResponse = input.nextLine();
                        melody.writeToFile(userResponse);
                    }

                } while (!(userResponse.equalsIgnoreCase("H")));
            } else if (userResponse.equalsIgnoreCase("C")) {
                System.out.print("Please enter file name: ");
                userResponse = input.nextLine();
                Song melody3 = new Song();
                melody.makeHeap(userResponse);
                        
            }
            else if (userResponse.equalsIgnoreCase("D")) {
                System.exit(0);
            }
        } while (!(userResponse.equalsIgnoreCase("D")));
    }
}