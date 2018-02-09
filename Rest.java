public class Rest extends MusicNote {
    String R; //pitchSymbol
    char rest;
    int position;
    double duration;
    String dur;
    boolean repeat;

    public Rest() {
        R = "r";
        rest = 'r';
    }
    
    public Rest(String a, boolean rep, String dur) {
        R= "r";
        rest = 'r';
        this.setRepeat(rep);
        this.setDuration(dur.charAt(0));
    }

    public void setPitch(int a) {
        return;
    }

    public void setPitch(String a) {
        return;
    }

    public void setDuration(char name) {
        dur = Character.toString(name);
        //Try block matches character to input and sets duration accordingly
        boolean setDur = true;
        while (setDur) {
            try {
                if (name == 'w' || name == 'W') {
                    duration = 1;
                    setDur = false;
                }
                else if (name == 'h' || name == 'H') {
                    duration = (1.0/2.0);
                    setDur = false;
                }
                else if (name == 'q' || name == 'Q') {
                    duration = (1.0/4.0);
                    setDur = false;
                }
                else if (name == 'e' || name == 'E') {
                    duration = (1.0/8.0);
                    setDur = false;
                }
                else if (name == 'i' || name == 'I') {
                    duration = (1.0/16.0);
                    setDur = false;
                }
                else {
                    throw new IllegalArgumentException("Invalid character");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid character. Enter note duration."); 
            }

        }
    }

        public void changePitch(int pitch) {
        return;
    }

    public char getDuration() {
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
        } else if (duration == (1.0/16.0)) {
            return 's';
        }
        else {
            return 'i';
        }
    }

    public String getPitchSymbol() {
        return R;
    }

    public int getPitchMIDIvalue() {
        return 0;
    }

    public double getPitchFrequency() {
        return 0;
    }
    
    public void setPosition(int pos) {
        this.position = pos;
    }
    
    public int getPosition() {
        return position;
    }
    
    public String toString() {
        return "r" + " ";
    }
    
    public void setRepeat(boolean rep) {
        repeat = rep;
    }
    
    public boolean getRepeat() {
        return repeat;
    }

}