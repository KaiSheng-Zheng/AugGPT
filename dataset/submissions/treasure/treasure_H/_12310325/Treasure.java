public class Treasure {
    private final int score;
    private final  Position position ;
    private boolean find;
    public Treasure(int score,Position position){

        this.position=position;
        this.score=score;

    }
    public int getScore(){
        return score;
    }
    public Object getPosition(){
        return position;
    }

    public void setFind(boolean find) {
        this.find = find;
    }

    public boolean isFind() {
        return find;
    }
}
