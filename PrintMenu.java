public class PrintMenu {
    public static void printMenu() {
        System.out.println("---------------SONG CONSTRUCTOR--------------");
        System.out.println("| Please choose from the following options: |");
        System.out.println("|- - - - - - - - - - - - - - - - - - - - - -|");
        System.out.println("| A) New Song        B)Import Song From File|");
        System.out.println("| C) Make Heap       D) Exit                |");
        System.out.println("|___________________________________________|");
    }
    
    public static void printNewSongSubMenu() {
        System.out.println("|------------------------NEW SONG---------------------|");
        System.out.println("| Please choose from the following options:           |");
        System.out.println("|- - - - - - - - - - - - - - - - - - - - - - - - - - -|");
        System.out.println("| A) Add note              B) View Song Length        |");
        System.out.println("| C) Reverse Song          D) View current notes      |");
        System.out.println("| E) Save Song To File     F) Change Tempo            |");
        System.out.println("| G) Append Song From File H) Exit                    |");
        System.out.println("|_____________________________________________________|");
    }
    
    public static void printFileSongSubMenu() {
        System.out.println("|--------------SONG FROM FILE---------------|");
        System.out.println("| Please choose from the following options: |");
        System.out.println("|- - - - - - - - - - - - - - - - - - - - - -|");
        System.out.println("| A) Choose File      B) View Current Notes |");
        System.out.println("| C) Add Notes        D) View Song Length   |");        
        System.out.println("| E) Reverse Song     F) Change Tempo       |");
        System.out.println("| G) Save To File     H) Exit               |");
        System.out.println("|___________________________________________|");
    }
    
    public static void printAddNoteMenu() {
         System.out.println("|--------------ADDING A NOTE---------------|");
        System.out.println("| Please choose from the following options: |");
        System.out.println("|- - - - - - - - - - - - - - - - - - - - - -|");
        System.out.println("| Type in a note(i.e. C4), a duration(i.e.  |");
        System.out.println("| 'q' for quarter note), and y if this      |");
        System.out.println("| note begins/concludes a repeated section  |");
        System.out.println("|___________________________________________|");
    }
}