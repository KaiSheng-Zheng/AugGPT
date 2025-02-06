
public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        Treasure.cnt=treasures.length;
        isActive=true;
    }
    public int hasTreasure(Position position)
    {
        for(Treasure t:treasures)
        {
            if(t.isAval()&&t.getPosition().getCol()==position.getCol()&&t.getPosition().getRow()==position.getRow())
            {
                //update(new Position(t.getPosition().getRow(),t.getPosition().getCol()));
                return t.getScore();
            }
        }
        return 0;
    }
    public void update(Position position)
    {
        for(int i=0;i<treasures.length;i++)
        {
            if(treasures[i].isAval()&&treasures[i].getPosition().getCol()==position.getCol()&&treasures[i].getPosition().getRow()==position.getRow())
            {
                treasures[i].disval();
                Treasure.cnt--;
                if(Treasure.cnt==0)
                {
                    setActive(false);
                }
            }
        }
    }

}
