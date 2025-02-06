public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures){
        this.columns=columns;
        this.rows=rows;
        this.treasures=treasures;
        isActive=true;
    }
    public int hasTreasure(Position position){
        for (int i = 0; i < treasures.length; i++) {
            if(treasures[i].getPosition().equals(position)){
                return treasures[i].getScore();
            }
        }
        return 0;
    }
    
}
