
public class Map{
    private final int rows;
    private final int columns;
    private Treasure[] treasures;
    public Map(int rows,int columns,Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
    }
    public int getRows(){
        return rows;
    }
    public int getColumns(){
        return columns;
    }
    public int hasTreasure(Position position){
        for(int i=0;i<treasures.length;i++)
            if(position.equals(treasures[i].getPosition())&&!treasures[i].hasBeenFound())
                return treasures[i].getScore();
        return 0;
    }
    public void update(Position position){
        for(int i=0;i<treasures.length;i++)
            if(position.equals(treasures[i].getPosition())&&!(treasures[i].hasBeenFound()))
                treasures[i].invalidate();
    }
    public int getScore(Position position){
        for(int i=0;i<treasures.length;i++)
            if(position.equals(treasures[i].getPosition())&&!(treasures[i].hasBeenFound()))
                return treasures[i].getScore();
            return 0;
    }
    public boolean isActive(){
        for(int i=0;i<treasures.length;i++)
            if(!treasures[i].hasBeenFound())
                return true;
        return false;
    }
}
