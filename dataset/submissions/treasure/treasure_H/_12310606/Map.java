public class Map
{
    private final int rows;
    private final int columns;
    private boolean isActive;
    private int total=0;
    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures)
    {
        this.columns=columns;
        this.rows=rows;
        this.treasures=treasures;
        total=treasures.length;
        isActive=true;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int hasTreasure(Position position)
    {
        int i;
        int t;
        for(i=0;i<treasures.length;i++)
        {
            if(treasures[i].getPosition().equals(position))
            {
                return treasures[i].getScore();
            }
        }
        return 0;
    }

    public void update(Position position)
    {
        int i;
        for(i=0;i<treasures.length;i++)
        {
            if(treasures[i].getPosition().equals(position))
            {
                if(treasures[i].isExist())
                {
                    treasures[i].changeExist();
                    total--;
                }
                break;
            }
        }
        if(total==0)
            isActive = false;
    }

    public boolean isActive()
    {
        return this.isActive;
    }
}
