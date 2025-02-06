public class Treasure {
    private final int score;
    private final Position position;

    public Treasure(int score, Position position) {
        this.score = score;
        this.position = position;
    }

    public int getScore(){
        return this.score;
    }

    public Position getPosition(){
        return this.position;
    }

    private boolean valid=true;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
