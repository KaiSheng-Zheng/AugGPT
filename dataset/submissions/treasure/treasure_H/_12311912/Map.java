public class Map
{
    private final int rows;
    private final int columns;
    private boolean isActive = false;
    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures)
    {
        this.rows = rows;
        this.columns = columns;
        isActive = true;
        this.treasures = treasures;
    }
    public int hasTreasure(Position positon)
    {
        for (Treasure i : treasures)
            if (i.getPosition().equals(positon))
                return i.getScore();
        return 0;
    }
    public void update(Position position)
    {
        int count = 0;
        Treasure[] newtreasure = new Treasure[treasures.length];
        for (int i = 0;i < treasures.length;i++)
            if (!treasures[i].getPosition().equals(position))
                newtreasure[count++] = treasures[i];
        treasures = new Treasure[count];
        for (int i = 0;i < treasures.length;i++)
            treasures[i] = newtreasure[i];
        if (count == 0)
        {
            isActive = false;
        }
    }
    public boolean isActive()
    {
        return isActive;
    }
    public int getRows()
    {
        return rows;
    }
    public int getColumns()
    {
        return columns;
    }
}
