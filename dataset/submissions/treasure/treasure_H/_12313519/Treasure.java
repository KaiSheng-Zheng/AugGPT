public class Treasure {
    private final int score;
    private boolean flag=true;
    private final Position position;
    public Treasure(int score, Position position){
        this.score = score;
        this.position = position;
    }

    public int getScore() {
        return score;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}