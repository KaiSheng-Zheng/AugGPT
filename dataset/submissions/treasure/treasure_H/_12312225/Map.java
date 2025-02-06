public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private int[] isTreasure;
    public Map(int rows, int columns, Treasure[] treasures)
    {
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
        isActive=true;
        isTreasure=new int[treasures.length];
    }
    public int hasTreasure(Position position)
    {
        if(!this.isActive())
        {
            return 0;
        }
        for(int i=0;i<treasures.length;i++)
        {
            if(isTreasure[i]==0&&treasures[i].getPosition().equals(position))
            {
                return treasures[i].getScore();
            }
        }
        return 0;
    }
    public boolean isActive() {
        return isActive;
    }
    public int getColumns() {
        return columns;
    }
    public int getRows() {
        return rows;
    }
    public void update(Position position)
    {
        if(!this.isActive)
        {
            return;
        }
        for(int i=0;i<treasures.length;i++)
        {
            if(isTreasure[i]!=1&&treasures[i].getPosition().equals(position))
            {
                isTreasure[i]=1;
            }
        }
        int you=0;
        for(int i:isTreasure)
        {
            if (i == 0)
            {
                you = 1;
                break;
            }
        }
        if(you==0)
        {
            this.isActive=false;
        }
    }
}