public class Repetition {
    private boolean repetition;
    private int position;
    
    public Repetition(boolean rep, int pos) {
        repetition = rep;
        position = pos;
    }
    public boolean getRepetition() {
        return repetition;
    }
    public void setRepetition(boolean rep) {
        repetition = rep;
    }
    public void setPosition(int pos) {
        position = pos;
    }
    public int getPosition() {
        return position;
    }
}