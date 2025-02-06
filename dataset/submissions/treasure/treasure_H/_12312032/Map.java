public class Map
{
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures)
    {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.isActive = true;
    }
    public int getRows()
    {
        return rows;
    }
    public int getCol()
    {
        return columns;
    }
    public int hasTreasure(Position position)
    {
        for(int x=0; x<treasures.length; x++)
        {
            if (treasures[x].getPosition().equals(position))
                return treasures[x].getScore();
        }
        return 0;
    }
    public void update(Position position)
    {
        for(int x=0; x<treasures.length; x++)
        {
            if (treasures[x].getPosition().equals(position))
            {
                treasures[x] = null;
            }
        }
    }
    public boolean isActive()
    {
        return isActive;
    }
}
