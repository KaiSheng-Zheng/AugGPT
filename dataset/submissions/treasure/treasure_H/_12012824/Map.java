public class Map {
    private final int rows;

    public int getRows() {
        return rows;
    }

    private final int columns;

    public int getColumns() {
        return columns;
    }

    private boolean isActive;

    public void setActive(boolean active) {
        isActive = active;
    }


    private Treasure[] treasures;

    public void setTreasures(Treasure[] treasures) {
        this.treasures = treasures;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public Map(int rows, int columns, Treasure[]treasures){
        this.rows = rows;
        this.columns =columns;
        this.treasures = treasures;
    }
    public int hasTreasure(Position position){
        for (int i = 0; i<treasures.length; i++){
            if (treasures[i]!=null&&position.equals(treasures[i].getPosition())){
                return treasures[i].getScore();
            }
        }
        return 0;
    }
    public void update(Position position){
        for (int i = 0; i<treasures.length; i++){
            if (treasures[i]!=null&&position.equals(treasures[i].getPosition())){
                treasures[i]=null;
            }
        }
    }
    public boolean isActive(){
        for (int i = 0; i<treasures.length; i++){
            if (treasures[i]!=null){
                return true;
            }
        }return false;
    }
}