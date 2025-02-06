public class Map
{
    private final int rows;
    private final int columns;
    int tt,cn;
    private boolean isActive;
    private Treasure[] treasures;
    private boolean[] vis;
    public Map(int rows, int columns, Treasure[] treasures)
    {
        this.rows=rows;
        this.columns=columns;
        tt=treasures.length;cn=0;
        isActive=true;
        this.treasures=treasures;
        vis=new boolean[tt];
    }
    public int hasTreasure(Position position)
    {
        for(int i=0;i<tt;i++)
        {
            if(!vis[i]&&treasures[i].getPosition().equals(position))return treasures[i].getScore();
        }
        return 0;
    }
    public void update(Position position)
    {
        for(int i=0;i<tt;i++)
        {
            if(treasures[i].getPosition().equals(position))
            {
                vis[i]=true;
                cn++;
                if(cn==tt)isActive=false;
                break;
            }
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
