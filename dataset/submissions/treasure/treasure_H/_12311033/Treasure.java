public class Treasure {
    private final int score;
    private final Position position;
    private boolean flag;
    public Treasure(int score, Position position){
        this.score = score;
        this.position = position;
        this.flag = true;
    }
    public int getScore(){
        int score1 = this.score;
        return score1;
    }
    public void setFlag(){
        flag = false;
    }
    public boolean canOccupy(){
        return flag;
    }
    public Position getPosition(){
        return this.position;
    }
}
