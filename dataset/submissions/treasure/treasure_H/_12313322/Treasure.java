import java.util.*;
public class Treasure
{
    private final int score;
    private final Position position;
    public Treasure(int score,Position position)
    {
        this.score=score;
        this.position=position;
    }
    public Position getPosition()
    {
        return this.position;
    }
    public int getScore()
    {
        return this.score;
    }
}
