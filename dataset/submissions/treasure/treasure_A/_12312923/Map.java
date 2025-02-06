public class Map
{
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.isActive= treasures.length != 0;
    }
    public int hasTreasure(Position position)
    {
        for(Treasure a:treasures)
        {
            if(a.getPosition().equals(position)&& a.isNotFound())
                return a.getScore();
        }
        return 0;
    }
    public void update(Position position)
    {
        boolean hasTreasure=false;
        for(Treasure a:treasures)
        {
            if(a.getPosition().equals(position)&& a.isNotFound())
            {
                a.setNotFound(false);
            }
            if(a.isNotFound())
            {
                hasTreasure=true;
            }
        }
        if(!hasTreasure) setActive(false);
    }

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

    public Treasure[] getTreasures() {
        return treasures;
    }

    public void setTreasures(Treasure[] treasures) {
        this.treasures = treasures;
    }
}
