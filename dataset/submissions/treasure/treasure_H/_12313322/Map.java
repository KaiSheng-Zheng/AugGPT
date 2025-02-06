import java.util.*;
public class Map
{
    private final int rows;
    private final int columns;
    private static boolean isActive=true;
    private Treasure[] treasures;
    private static int tot;
    private static int cnt[]=new int[10000001];
    public Map(int rows,int columns,Treasure[] treasures)
    {
        this.rows=rows-1;
        this.columns=columns-1;
        this.treasures=treasures;
        tot=treasures.length;
        for(int i=0;i<tot;i++)
            cnt[i]=1;
    }
    public boolean isActive()
    {
        update(new Position(0,0));
        return this.isActive;
    }
    public int getRows()
    {
        return this.rows;
    }
    public int getColumns()
    {
        return this.columns;
    }
    public int hasTreasure(Position position)
    {
        int l=treasures.length;
        for(int i=0;i<l;i++)
            if(treasures[i].getPosition().equals(position))
                return treasures[i].getScore()*cnt[i];
        return 0;
    }
    public int takeTreasure(Position position)
    {
        int l=treasures.length;
        for(int i=0;i<l;i++)
            if(cnt[i]==1 && treasures[i].getPosition().equals(position))
            {
                cnt[i]=0;
                tot--;
                update(position);
                return treasures[i].getScore();
            }
        return 0;
    }
    public void update(Position position)
    {
        int l=treasures.length;
        int t=0;
        for(int i=0;i<l;i++)
            if(cnt[i]==1)
            {
                t=1;
                this.isActive=true;
            }
        if(t==0) this.isActive=false;
    }
}
