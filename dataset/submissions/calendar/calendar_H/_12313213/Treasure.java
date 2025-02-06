public class Treasure {
    private final int score;
    private final Position position;
    private boolean find;


    public boolean isFind() {
        return find;
    }

    public void setFind(boolean find) {
        this.find = find;
    }



    public Treasure(int score, Position position) {
        this.score = score;
        this.position = position;
        this.find = true;
    }

    public int getScore() {
        return score;
    }

    public Position getPosition() {
        return position;
    }
}
