public class Treasure {
    private final int score;
    private final Position position;
    private boolean isFind;

    public Treasure(int score, Position position) {
        this.score = score;
        this.position = position;
        this.isFind=false;
    }

    public int getScore() {
        if(isFind){
            return 0;
        }else{
            return score;
        }
    }

    public Position getPosition() {
        return position;
    }

    public void setFind(boolean find) {
        isFind = find;
    }
}
