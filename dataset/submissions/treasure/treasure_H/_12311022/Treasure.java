

public class Treasure {
    private final int score;
    private final Position position;
    private int usedTime;
    public Treasure(int score,Position position){
    this.score=score;
    this.position=position;
    }

    public int getUsedTime() {
        return usedTime;
    }

    public void getUsed() {
        this.usedTime++;
    }

    public int getScore() {
        return score;
    }

    public Position getPosition() {
        return position;
    }
}
