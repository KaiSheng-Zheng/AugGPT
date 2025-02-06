public class Treasure {
    private int score;private final Position position;
    public int getScore(){return score;}public void setScore(int score){this.score=score;}
    public Position getPosition(){return position;}
    public Treasure(int sc,Position ps){score=sc;position=ps;}
}