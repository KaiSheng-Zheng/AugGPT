public class Treasure {
    private final int score;
    private final Position position;

    private boolean isactive;

    public Treasure(int score, Position position){
        this.score=score ;
        this.position = position;
        isactive = true;
    }

    public int getScore() {
        return score;
    }

    public Position getPosition() {
        return position;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public boolean isIsactive() {
        return isactive;
    }
}
