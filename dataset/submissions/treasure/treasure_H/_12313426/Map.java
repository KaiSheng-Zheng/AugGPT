public class Map
{
    private final int rows;
    private final int columns;
    private boolean isActive=true;
    private Treasure[]treasures;
    boolean b[][];
    private int m;
    public Map(int rows,int columns,Treasure[]treasures)
    {
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
        m=treasures.length;
        b=new boolean[rows][columns];
    }

    public int getRows()
    {
        return rows;
    }

    public int getColumns()
    {
        return columns;
    }

    public void setActive()
    {
        isActive=false;
    }
    public boolean isActive()
    {
        return isActive;
    }
    public int getM()
    {
        return m;
    }
    public void setM(int m)
    {
        this.m=m;
    }
    public int hasTreasure(Position position)
    {
        int sum=0;
        for(int i=0;i<treasures.length;i++)
        {
            if(treasures[i].getPosition().equals(position)&&!b[position.getRow()][position.getCol()])
            {
                sum+=treasures[i].getScore();
            }
        }
        return sum;
    }
    public void update(Position position)
    {
        b[position.getRow()][position.getCol()]=true;
    }
}
