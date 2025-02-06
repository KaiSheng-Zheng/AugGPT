

public class Treasure
{
    private final int score;
    private final Position position;

    private boolean isAval;

    public boolean isAval() {
        return isAval;
    }

    public void disval()
    {
        isAval=false;
    }
    public static int cnt=0;

    public Treasure(int score, Position position)
    {
        this.score=score;
        this.position=position;
        cnt++;
        isAval=true;
    }

    public int getScore() {
        return score;
    }

    public Position getPosition() {
        return position;
    }
}
