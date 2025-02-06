public class Treasure {
    private final int score;
    private final Position position;

    private boolean existance=true;

    public boolean isExistance() {
        return existance;
    }

    public void setExistance(boolean existance) {
        this.existance = existance;
    }

    public Treasure(int score, Position position){
        this.score=score;
        this.position=position;
    }

    public int getScore() {
        return score;
    }

    public Position getPosition() {
        return position;
    }
}