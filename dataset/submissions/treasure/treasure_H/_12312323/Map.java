public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private int numberOfTreasures=0;
    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.isActive = true;
        numberOfTreasures= treasures.length;
    }
    public int hasTreasure(Position position){
        for(int i=0;i<treasures.length;i++){
            if(treasures[i].getPosition().equals(position)){
                return treasures[i].getScore();
            }
        }
        return 0;
    }
    public void update(Position position)
    {
        for(int i=0;i<treasures.length;i++){
            if(treasures[i].getPosition().equals(position)){
                treasures[i].getPosition().setRow(-1);
                treasures[i].getPosition().setCol(-1);
                numberOfTreasures--;
            }
        }
        if (numberOfTreasures== 0) {
            isActive = false;
        }
    }
    public boolean isActive(){
        return isActive;
    }
    public int getRows(){
        return rows;
    }
    public int getColumns(){
        return columns;
    }

}
