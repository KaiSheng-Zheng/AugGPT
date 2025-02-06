//package A4_2;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures=treasures;
        isActive=true;
    }
    public int hasTreasure(Position position)
    {
        int sum=0;
        for(int i=0;i<treasures.length;i++)
            if(treasures[i].getPosition().equals(position))
                sum+=treasures[i].getScore();
        return sum;
    }
    public void update(Position position)
    {
        for(int i=0;i<treasures.length;i++)
            if(treasures[i].getPosition().equals(position))
                treasures[i].setSc(0);
    }
    public boolean isActive()
    {
        int sum=0;
        for(int i=0;i<treasures.length;i++)
            sum+=treasures[i].getScore();
        if(sum>0)
        {
            isActive=true;
            return true;
        }
        else
        {
            isActive=false;
            return false;
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
