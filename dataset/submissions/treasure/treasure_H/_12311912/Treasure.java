public class Treasure
{
    private final int score;
    private final Position position;
    public Treasure(int score,Position positon)
    {
        this.score = score;
        this.position = positon;
    }
    public int getScore()
    {
        return this.score;
    }
    public Position getPosition()
    {
        return this.position;
    }
}
