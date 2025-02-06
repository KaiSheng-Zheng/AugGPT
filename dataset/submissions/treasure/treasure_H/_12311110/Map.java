public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private int cnt;
    private Treasure[] treasures;
    public Map(int rows,int columns,Treasure[] treasures)
    {
        this.columns=columns;
        this.rows=rows;
        this.treasures=treasures;
        this.isActive=true;
        for(Treasure i:treasures)
        {
            cnt++;
        }
    }
    public int hasTreasure(Position position)
    {
        for(int i=1;i<=cnt;i++)
        {
            if(treasures[i-1].getPosition().equals(position))
            {
                return treasures[i-1].getScore();
            }
        }
        return 0;
    }
    public void update(Position position)
    {
        for(int i=1;i<=cnt;i++)
        {
            if(treasures[i-1].getPosition().equals(position))
            {
                for(int j=i;j<cnt;j++)
                {
                    treasures[j-1]=treasures[j];
                }
                cnt--;
                if(cnt==0) this.isActive=false;
            }
        }
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }
    public boolean isActive()
    {
        return isActive;
    }
}
