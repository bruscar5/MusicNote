import java.util.*;

public class MusicNote implements Note, Comparable  {
    /**
    * Brian Healy
    * CSC 153
    *Class MusicNote
    *Description: A Class that uses the instance variables pitch, MIDIPitch, strPitch, and duration to represent a
    *musical note. Accessor and mutator methods, describes below, allow user to set and get values of these variables
    *in multiple ways using different parameters. Class does not account for flat and sharp notes.
    */
    
    private double pitch = 261.63; //double pitch represents frequency in hz of note
    private int MIDIPitch = 60; //represents midi value of note
    private String strPitch = "C4"; //represents note in string
    private double duration; //sets duration of note
    int position;
    boolean repeat;
    
    public MusicNote() { //default constructor initializes to middle C
        setPitch("C4");
    }
    
    public MusicNote(String note, String duration) {
        char dur = duration.charAt(0);
        this.setPitch(note);
        this.setDuration(dur);
        this.setRepeat(false);
    }
    
     public MusicNote(String note, char duration, boolean repeatValue) {
        //char dur = duration.charAt(0);
        this.setPitch(note);
        this.setDuration(duration);
        this.setRepeat(repeatValue);
    }

    public MusicNote(int midi, String duration) {
        char dur = duration.charAt(0);
        this.setDuration(dur);
        this.setPitch(midi);
        this.setRepeat(false);
    }
    
    public MusicNote(int midi, char duration) {
        char dur = duration;
        this.setDuration(dur);
        this.setPitch(midi);
        this.setRepeat(false);
    }
    
    

    public String toString() {
        return this.strPitch + " " + Measure.timeToString(this.duration) + " " + this.getRepeat() + "\n";
    }
     /**
     * Sets note pitch using a String containing a letter and a number
     * @param p is a valid letter-number combination
     * where the letter is in the range A..G (upper or lowercase)
     * and the number is in the range 1..7
     * postcondition: pitch is set to specified value
     * @throws: IllegalArgumentException
     */
    public void setPitch(String p) {
        strPitch = p;
        boolean set = true;
        
        while (set) {
        try {
            if (p.charAt(0) == 'A' || p.charAt(0) == 'a')
            {
                if (p.charAt(1) == '0') {
                    this.setPitch(21);
                    set = false;
                }
                else if (p.charAt(1) == '1') {
                    this.setPitch(21 + 12);
                    set = false;
                }
                else if (p.charAt(1) == '2') {
                    this.setPitch(21 + 24);
                    set = false;
                }
                else if (p.charAt(1) == '3') {
                    this.setPitch(21 + 36);
                    set = false;
                }
                else if (p.charAt(1) == '4') {
                    this.setPitch(21 + 48);
                    set = false;
                }
                else if (p.charAt(1) == '5') {
                    this.setPitch(21 + 60);
                    set = false;
                }
                else if (p.charAt(1) == '6') {
                    this.setPitch(21 + 72);
                    set = false;
                }
                else if (p.charAt(1) == '7') {
                    this.setPitch(21 + 84);
                    set = false;
                }
            }
            else if (p.charAt(0) == 'B' || p.charAt(0) == 'b')
            {
                if (p.charAt(1) == '0') {
                    this.setPitch(23);
                    set = false;
                }
                else if (p.charAt(1) == '1') {
                    this.setPitch(23 + 12);
                    set = false;
                }
                else if (p.charAt(1) == '2') {
                    this.setPitch(23 + 24);
                    set = false;
                }
                else if (p.charAt(1) == '3') {
                    this.setPitch(23 + 36);
                    set = false;
                }
                else if (p.charAt(1) == '4') {
                    this.setPitch(23 + 48);
                    set = false;
                }
                else if (p.charAt(1) == '5') {
                    this.setPitch(23 + 60);
                    set = false;
                }
                else if (p.charAt(1) == '6') {
                    this.setPitch(23 + 72);
                    set = false;
                }
                else if (p.charAt(1) == '7') {
                    this.setPitch(23 + 84);
                    set = false;
                }
            }
            else if (p.charAt(0) == 'C' || p.charAt(0) == 'c')
            {
                if (p.charAt(1) == '1') {
                    this.setPitch(24 + 0);
                    set = false;
                }
                else if (p.charAt(1) == '2') {
                    this.setPitch(24 + 12);
                    set = false;
                }
                else if (p.charAt(1) == '3') {
                    this.setPitch(24 + 24);
                    set = false;
                }
                else if (p.charAt(1) == '4') {
                    this.setPitch(24 + 36);
                    set = false;
                }
                else if (p.charAt(1) == '5') {
                    this.setPitch(24 + 48);
                    set = false;
                }
                else if (p.charAt(1) == '6') {
                    this.setPitch(24 + 60);
                    set = false;
                }
                else if (p.charAt(1) == '7') {
                    this.setPitch(24 + 72);
                    set = false;
                }
            }
            else if (p.charAt(0) == 'D' || p.charAt(0) == 'd')
            {
                if (p.charAt(1) == '1') {
                    this.setPitch(26);
                    set = false;
                }
                else if (p.charAt(1) == '3') {
                    this.setPitch(26 + 12);
                    set = false;
                }
                else if (p.charAt(1) == '4') {
                    this.setPitch(26 + 24);
                    set = false;
                }
                else if (p.charAt(1) == '5') {
                    this.setPitch(26 + 36);
                    set = false;
                }
                else if (p.charAt(1) == '6') {
                    this.setPitch(26 + 48);
                    set = false;
                }
                else if (p.charAt(1) == '7') {
                    this.setPitch(26 + 60);
                    set = false;
                }
                else if (p.charAt(1) == '8') {
                    this.setPitch(26 + 72);
                    set = false;
                }
            }
            else if (p.charAt(0) == 'E' || p.charAt(0) == 'e')
            {
                if (p.charAt(1) == '1') {
                    this.setPitch(28);
                    set = false;
                }
                else if (p.charAt(1) == '2') {
                    this.setPitch(28 + 12);
                    set = false;
                }
                else if (p.charAt(1) == '3') {
                    this.setPitch(28 + 24);
                    set = false;
                }
                else if (p.charAt(1) == '4') {
                    this.setPitch(28 + 36);
                    set = false;
                }
                else if (p.charAt(1) == '5') {
                    this.setPitch(28 + 48);
                    set = false;
                }
                else if (p.charAt(1) == '6') {
                    this.setPitch(28 + 60);
                    set = false;
                }
                else if (p.charAt(1) == '7') {
                    this.setPitch(28 + 72);
                    set = false;
                }
            }
            else if (p.charAt(0) == 'F' || p.charAt(0) == 'f')
            {
                if (p.charAt(1) == '1') {
                    this.setPitch(29);
                    set = false;
                }
                else if (p.charAt(1) == '2') {
                    this.setPitch(29 + 12);
                    set = false;
                }
                else if (p.charAt(1) == '3') {
                    this.setPitch(29 + 24);
                    set = false;
                }
                else if (p.charAt(1) == '4') {
                    this.setPitch(29 + 36);
                    set = false;
                }
                else if (p.charAt(1) == '5') {
                    this.setPitch(29 + 48);
                    set = false;
                }
                else if (p.charAt(1) == '6') {
                    this.setPitch(29 + 60);
                    set = false;
                }
                else if (p.charAt(1) == '7') {
                    this.setPitch(29 + 72);
                    set = false;
                }
            }
            else if (p.charAt(0) == 'G' || p.charAt(0) == 'g')
            {
                if (p.charAt(1) == '1') {
                    this.setPitch(31);
                    set = false;
                }
                else if (p.charAt(1) == '2') {
                    this.setPitch(31 + 12);
                    set = false;
                }
                else if (p.charAt(1) == '3') {
                    this.setPitch(31 + 24);
                    set = false;
                }
                else if (p.charAt(1) == '4') {
                    this.setPitch(31 + 36);
                    set = false;
                }
                else if (p.charAt(1) == '5') {
                    this.setPitch(31 + 48);
                    set = false;
                }
                else if (p.charAt(1) == '6') {
                    this.setPitch(31 + 60);
                    set = false;
                }
                else if (p.charAt(1) == '7') {
                    this.setPitch(31 + 72);
                    set = false;
                }
            }
            else {
                throw new IllegalArgumentException("Illegal argument.");
            }
        } catch(IllegalArgumentException e) {
            Rest r = new Rest(this.toString(), this.getRepeat(), Character.toString(this.getDuration()));
            set = false;
            return;
        }
    }

    }

    /**
     * Sets note pitch using a whole number value
     * @param midi is a valid MIDI value for the notes in the range
     * A1 - C8
     * postcondition: pitch is set to specified value
     * @throws: IllegalArgumentException
     */    
    public void setPitch(int midi) {
        try {
             if (midi < 0 || midi > 108) {
                throw new IllegalArgumentException();
            }
            else if (midi == 21) {
                pitch = 27.500 * (Math.pow(2, (0.0/12.0)));
                strPitch = "A1";
            } else if (midi == 23) {
                pitch = 27.500 * (Math.pow(2, (2.0/12.0)));
                strPitch = "B1";
            } else if (midi == 24) {
                pitch = 27.500 * (Math.pow(2, (3.0/12.0)));
                strPitch = "C1";
            } else if (midi == 26) {
                pitch = 27.500 * (Math.pow(2, (5.0/12.0)));
                strPitch = "D1";
            } else if (midi == 28) {
                pitch = 27.500 * (Math.pow(2, (7.0/12.0)));
                strPitch = "E1";
            } else if (midi == 29) {
                pitch = 27.500 * (Math.pow(2, (8.0/12.0)));
                strPitch = "F1";
            } else if (midi == 31) {
                pitch = 27.500 * (Math.pow(2, (10.0/12.0)));
                strPitch = "G1";
            } else if (midi == 33) {
                pitch = 27.500 * (Math.pow(2, (12.0/12.0)));
                strPitch = "A2";
            } else if (midi == 35) {
                pitch = 27.500 * (Math.pow(2, (14.0/12.0)));
                strPitch = "B2";
            } else if (midi == 36) {
                pitch = 27.500 * (Math.pow(2, (15.0/12.0)));
                strPitch = "C2";
            } else if (midi == 38) {
                pitch = 27.500 * (Math.pow(2, (17.0/12.0)));
                strPitch = "D2";
            } else if (midi == 40) {
                pitch = 27.500 * (Math.pow(2, (19.0/12.0)));
                strPitch = "E2";
            } else if (midi == 41) {
                pitch = 27.500 * (Math.pow(2, (20.0/12.0)));
                strPitch = "F2";
            } else if (midi == 43) {
                pitch = 27.500 * (Math.pow(2, (22.0/12.0)));
                strPitch = "G2";
            } else if (midi == 45) {
                pitch = 27.500 * (Math.pow(2, (24.0/12.0)));
                strPitch = "A3";
            } else if (midi == 47) {
                pitch = 27.500 * (Math.pow(2, (26.0/12.0)));
                strPitch = "B3";
            } else if (midi == 48) {
                pitch = 27.500 * (Math.pow(2, (27.0/12.0)));
                strPitch = "C3";
            } else if (midi == 50) {
                pitch = 27.500 * (Math.pow(2, (29.0/12.0)));
                strPitch = "D3";
            } else if (midi == 52) {
                pitch = 27.500 * (Math.pow(2, (31.0/12.0)));
                strPitch = "E3";
            } else if (midi == 53) {
                pitch = 27.500 * (Math.pow(2, (32.0/12.0)));
                strPitch = "F3";
            } else if (midi == 55) {
                pitch = 27.500 * (Math.pow(2, (34.0/12.0)));
                strPitch = "G3";
            } else if (midi == 57) {
                pitch = 27.500 * (Math.pow(2, (36.0/12.0)));
                strPitch = "A4";
            } else if (midi == 59) {
                pitch = 27.500 * (Math.pow(2, (38.0/12.0)));
                strPitch = "B4";
            } else if (midi == 60) {
                pitch = 27.500 * (Math.pow(2, (39.0/12.0)));
                strPitch = "C4";
            } else if (midi == 62) {
                pitch = 27.500 * (Math.pow(2, (41.0/12.0)));
                strPitch = "D4";
            } else if (midi == 64) {
                pitch = 27.500 * (Math.pow(2, (43.0/12.0)));
                strPitch = "E4";
            } else if (midi == 65) {
                pitch = 27.500 * (Math.pow(2, (44.0/12.0)));
                strPitch = "F4";
            } else if (midi == 67) {
                pitch = 27.500 * (Math.pow(2, (46.0/12.0)));
                strPitch = "G4";
            } else if (midi == 69) {
                pitch = 27.500 * (Math.pow(2, (48.0/12.0)));
                strPitch = "A5";
            } else if (midi == 71) {
                pitch = 27.500 * (Math.pow(2, (50.0/12.0)));
                strPitch = "B5";
            } else if (midi == 72) {
                pitch = 27.500 * (Math.pow(2, (51.0/12.0)));
                strPitch = "C5";
            } else if (midi == 74) {
                pitch = 27.500 * (Math.pow(2, (53.0/12.0)));
                strPitch = "D5";
            } else if (midi == 76) {
                pitch = 27.500 * (Math.pow(2, (55.0/12.0)));
                strPitch = "E5";
            } else if (midi == 77) {
                pitch = 27.500 * (Math.pow(2, (56.0/12.0)));
                strPitch = "F5";
            } else if (midi == 79) {
                pitch = 27.500 * (Math.pow(2, (58.0/12.0)));
                strPitch = "G5";
            } else if (midi == 81) {
                pitch = 27.500 * (Math.pow(2, (60.0/12.0)));
                strPitch = "A6";
            } else if (midi == 83) {
                pitch = 27.500 * (Math.pow(2, (62.0/12.0)));
                strPitch = "B6";
            } else if (midi == 84) {
                pitch = 27.500 * (Math.pow(2, (63.0/12.0)));
                strPitch = "C6";
            } else if (midi == 86) {
                pitch = 27.500 * (Math.pow(2, (65.0/12.0)));
                strPitch = "D6";
            } else if (midi == 88) {
                pitch = 27.500 * (Math.pow(2, (67.0/12.0)));
                strPitch = "E6";
            } else if (midi == 89) {
                pitch = 27.500 * (Math.pow(2, (68.0/12.0)));
                strPitch = "F6";
            } else if (midi == 91) {
                pitch = 27.500 * (Math.pow(2, (70.0/12.0)));
                strPitch = "G6";
            } else if (midi == 93) {
                pitch = 27.500 * (Math.pow(2, (72.0/12.0)));
                strPitch = "A7";
            } else if (midi == 95) {
                pitch = 27.500 * (Math.pow(2, (74.0/12.0)));
                strPitch = "B7";
            } else if (midi == 96) {
                pitch = 27.500 * (Math.pow(2, (75.0/12.0)));
                strPitch = "C7";
            } else if (midi == 98) {
                pitch = 27.500 * (Math.pow(2, (77.0/12.0)));
                strPitch = "D7";
            } else if (midi == 100) {
                pitch = 27.500 * (Math.pow(2, (79.0/12.0))); 
                strPitch = "E7";
            } else if (midi == 101) {
                pitch = 27.500 * (Math.pow(2, (80.0/12.0)));
                strPitch = "F7";
            } else if (midi == 103) {
                pitch = 27.500 * (Math.pow(2, (82.0/12.0)));
                strPitch = "G7";
            } else if (midi == 105) {
                pitch = 27.500 * (Math.pow(2, (84.0/12.0)));
                strPitch = "A8";
            } else if (midi == 107) {
                pitch = 27.500 * (Math.pow(2, (86.0/12.0)));
                strPitch = "B8";
            } else if (midi == 108) {
                pitch = 27.500 * (Math.pow(2, (87.0/12.0)));
                strPitch = "C8";
            }
       } catch (IllegalArgumentException e) {
           Scanner kb = new Scanner(System.in);
           System.out.println("Midi value out of range. Please enter new value: ");
           midi = kb.nextInt();}
    }

    /**
      * Sets note duration to specified value
      * @param name is a char from the set {w, h, q, e, s}
      * representing whole, half, quarter, eighth and sixteenth 
      * notes respectively
      * postcondition: duration is set to specified value
      * @throws: IllegalArgumentException
      */
    public void setDuration(char name) {
        //Try block matches character to input and sets duration accordingly
        try {
            if (name == 'w' || name == 'W') {
                duration = 1;
            }
            else if (name == 'h' || name == 'H') {
                duration = (1.0/2.0);
            }
            else if (name == 'q' || name == 'Q') {
                duration = (1.0/4.0);
            }
            else if (name == 'e' || name == 'E') {
                duration = (1.0/8.0);
            }
            else if (name == 'i' || name == 'I') {
                duration = (1.0/16.0);
            }
            else {
                throw new IllegalArgumentException("Invalid character");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid character. Enter note duration."); 
        }
    }

    /**
     * Changes pitch up or down by specified factor
     * @param factor is an int value representing the
     * number of pitches between the current pitch and the desired
     * pitch; factor must fall within the possible range of values
     * such that pitch cannot be set above C8 or below A0
     * postcondition: pitch is changed by specified factor;
     * if factor is positive, pitch will be higher and if negative,
     * pitch will be lower
     * @throws IllegalArgumentException
     */
    public void changePitch(int factor) {
        pitch = pitch * Math.pow(2, (factor/12));
        this.setPitch(factor + MIDIPitch);
    }

    public char getDuration () {
        //checks value of duration to determine which char to return
        if (duration == 1) {
            return 'w';
        }
        else if (duration == (1.0/2.0)) {
            return 'h';
        }
        else if (duration == (1.0/4.0)) {
            return 'q';
        }
        else if (duration == (1.0/8.0)) {
            return 'e';
        }
        else {
            return 'i';
        }
    }

    /**
     * Returns note's pitch symbol
     * @return String version of pitch: e.g. C4 for middle C
     */
    public String getPitchSymbol() {
        if (MIDIPitch % 12 == 9) {
            if (MIDIPitch / 12 == 1) {
                strPitch = "A0";
            }
            else if (MIDIPitch / 12 == 2) {
                strPitch = "A1";
            }
            else if (MIDIPitch / 12 == 3) {
                strPitch = "A2";
            }
            else if (MIDIPitch / 12 == 4) {
                strPitch = "A3";
            }
            else if (MIDIPitch / 12 == 5) {
                strPitch = "A4";
            }
            else if (MIDIPitch / 12 == 6) {
                strPitch = "A5";
            }
            else if (MIDIPitch / 12 == 7) {
                strPitch = "A6";
            }
            else if (MIDIPitch / 12 == 8) {
                strPitch = "A7";
            }
        } else if (MIDIPitch % 12 == 11) {
            if (MIDIPitch / 12 == 1) {
                strPitch = "B0";
            }
            else if (MIDIPitch / 12 == 2) {
                strPitch = "B1";
            }
            else if (MIDIPitch / 12 == 3) {
                strPitch = "B2";
            }
            else if (MIDIPitch / 12 == 4) {
                strPitch = "B3";
            }
            else if (MIDIPitch / 12 == 5) {
                strPitch = "B4";
            }
            else if (MIDIPitch / 12 == 6) {
                strPitch = "B5";
            }
            else if (MIDIPitch / 12 == 7) {
                strPitch = "B6";
            }
            else if (MIDIPitch / 12 == 8) {
                strPitch = "B7";
            }
        } else if (MIDIPitch % 12 == 0) {
            if (MIDIPitch / 12 == 2) {
                strPitch = "C1";
            }
            else if (MIDIPitch / 12 == 3) {
                strPitch = "C2";
            }
            else if (MIDIPitch / 12 == 4) {
                strPitch = "C3";
            }
            else if (MIDIPitch / 12 == 5) {
                strPitch = "C4";
            }
            else if (MIDIPitch / 12 == 6) {
                strPitch = "C5";
            }
            else if (MIDIPitch / 12 == 7) {
                strPitch = "C6";
            }
            else if (MIDIPitch / 12 == 8) {
                strPitch = "C7";
            }
            else if (MIDIPitch / 12 == 9) {
                strPitch = "C8";
            }
        } else if (MIDIPitch % 12 == 2) {
            if (MIDIPitch / 12 == 2) {
                strPitch = "D1";
            }
            else if (MIDIPitch / 12 == 3) {
                strPitch = "D2";
            }
            else if (MIDIPitch / 12 == 4) {
                strPitch = "D3";
            }
            else if (MIDIPitch / 12 == 5) {
                strPitch = "D4";
            }
            else if (MIDIPitch / 12 == 6) {
                strPitch = "D5";
            }
            else if (MIDIPitch / 12 == 7) {
                strPitch = "D6";
            }
            else if (MIDIPitch / 12 == 8) {
                strPitch = "D7";
            }

        }
        else if (MIDIPitch % 12 == 4) {
            if (MIDIPitch / 12 == 2) {
                strPitch = "E1";
            }
            else if (MIDIPitch / 12 == 3) {
                strPitch = "E2";
            }
            else if (MIDIPitch / 12 == 4) {
                strPitch = "E3";
            }
            else if (MIDIPitch / 12 == 5) {
                strPitch = "E4";
            }
            else if (MIDIPitch / 12 == 6) {
                strPitch = "E5";
            }
            else if (MIDIPitch / 12 == 7) {
                strPitch = "E6";
            }
            else if (MIDIPitch / 12 == 8) {
                strPitch = "E7";
            }
        }
        else if (MIDIPitch % 12 == 3) {
            if (MIDIPitch / 12 == 5) {
                strPitch = "F1";
            }
            else if (MIDIPitch / 12 == 3) {
                strPitch = "F2";
            }
            else if (MIDIPitch / 12 == 4) {
                strPitch = "F3";
            }
            else if (MIDIPitch / 12 == 5) {
                strPitch = "F4";
            }
            else if (MIDIPitch / 12 == 6) {
                strPitch = "F5";
            }
            else if (MIDIPitch / 12 == 7) {
                strPitch = "F6";
            }
            else if (MIDIPitch / 12 == 8) {
                strPitch = "F7";
            }
        }  else if (MIDIPitch % 12 == 7) {
            if (MIDIPitch / 12 == 2) {
                strPitch = "G1";
            }
            else if (MIDIPitch / 12 == 3) {
                strPitch = "G2";
            }
            else if (MIDIPitch / 12 == 4) {
                strPitch = "G3";
            }
            else if (MIDIPitch / 12 == 5) {
                strPitch = "G4";
            }
            else if (MIDIPitch / 12 == 6) {
                strPitch = "G5";
            }
            else if (MIDIPitch / 12 == 7) {
                strPitch = "G6";
            }
            else if (MIDIPitch / 12 == 8) {
                strPitch = "G7";
            }
        }

        return strPitch;
    }

    /**
     * Returns note's MIDI value
     * @return an int version of pitch: valid MIDI value
     */
    public int getPitchMIDIvalue() {
        return MIDIPitch;
    }

    
    public void setPosition(int pos) {
        this.position = pos;
    }
    
    public int getPosition() {
        return position;
    }
    
    /**
     * Returns note's frequency in Hertz
     * @return pitch represented by double value in Hertz
     */
    public double getPitchFrequency() {
        return pitch;
    }
    
    public void setRepeat(boolean rep) {
        repeat = rep;
    }
    
    public boolean getRepeat() {
        return repeat;
    }
    
    public int compareMIDI(MusicNote other) {
        if (this.getPitchMIDIvalue() < other.getPitchMIDIvalue()) {
            return -1;
        } else if (this.getPitchMIDIvalue() == other.getPitchMIDIvalue()) {
            return -0;
        } else {
            return 1;
        }
    }
    
    public int compareDuration(MusicNote other) {
        if (Measure.timeToDouble(Character.toString(this.getDuration())) < Measure.timeToDouble(Character.toString(other.getDuration())))
        { 
            return -1;
        } else         if (Measure.timeToDouble(Character.toString(this.getDuration())) > Measure.timeToDouble(Character.toString(other.getDuration())))
        {
            return 0;
        } else {
            return 1;
        }
        
    }
    
    public int compareTo(Object other) {
        if (this.compareMIDI((MusicNote)(other)) < 1) {
            return -1;
        } else if (this.compareMIDI((MusicNote)(other)) > 1) {
            return 1;
        } else {
            return 0;
        }
    }
}