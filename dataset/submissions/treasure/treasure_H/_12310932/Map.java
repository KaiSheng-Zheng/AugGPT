import java.util.ArrayList;
import java.util.Arrays;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    ArrayList<Treasure>treasures=new ArrayList<>();
    public Map(int rows, int columns, Treasure[] treasures)
    {
        this.columns=columns;
        this.rows=rows;
        this.isActive=true;
        for (int i=0;i<treasures.length;i++)this.treasures.add(treasures[i]);
    }
    public int hasTreasure(Position position)
    {
        for (Treasure t:treasures)
        {
            if(t.getPosition()==position)return t.getScore();
        }
        return 0;
    }
    public void update(Position position)
    {
        for (int i=0;i<treasures.size();i++)
        {
            if(treasures.get(i).getPosition().equals(position))
            {
                treasures.remove(i);
                if(treasures.isEmpty())
                {
                    isActive=false;
                }
            }
        }
    }
    public boolean isActive()
    {
        return isActive;
    }
    public int getRows() {
        return rows;
    }
    public int getColumns() {
        return columns;
    }
}
