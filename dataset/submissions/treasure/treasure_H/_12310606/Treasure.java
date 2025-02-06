public class Treasure
{
    private final int score;
    private final Position position;
    private boolean isExist;
    public Treasure(int score, Position position)
    {
        this.score=score;
        this.position=position;
        isExist=true;
    }
    public int getScore()
    {
        if(isExist)
        {
//            isExist=false;
//            System.out.printf("(%d,%d) treasure %d is taken\n",position.getRow(),position.getCol(),score);
            return score;
        }
        return 0;
    }
    public Position getPosition()
    {
        return position;
    }
    public void changeExist()
    {
        this.isExist=false;
    }
    public boolean isExist()
    {
        return isExist;
    }
}