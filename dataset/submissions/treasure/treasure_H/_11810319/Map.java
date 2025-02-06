public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private  Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures){
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
    }

    public int hasTreasure(Position position){
        for(int i = 0; i < treasures.length; i++){
            if (treasures[i].getPosition() == position){
                return treasures[i].getScore();
            }
        }
        return 0;
    }
    public void update(Position position){
        for(int i = 0; i < treasures.length; i++){
            if (treasures[i].getPosition() == position){
                treasures[i] = null;
            }
        }
    }
    public boolean isActive(){
        int counter = 0;
        for(int i = 0; i < treasures.length; i++){
            if(treasures[i] == null){
                counter++;
            }
        }
        if(counter == treasures.length){
            return false;
        }else {
            return true;
        }
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }
}
