public class Treasure {
    private final int score;
    private final Position position;
    private int check;
    public int getScore() {
        return score;
    }

    public Position getPosition() {
        return position;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public int getCheck() {
        return check;
    }

    public Treasure(int score, Position position) {
        this.score = score;
        this.position = position;
        this.check = 1;
    }


}