public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private int treasures_been_found;

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public boolean getisActive() {
        return isActive;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public void setTreasures(Treasure[] treasures) {
        this.treasures = treasures;
    }

    public boolean isActive() {
        return isActive;
    }


    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.isActive = true;
        this.treasures_been_found = 0;
    }

    public int hasTreasure(Position position){
        for(int i = 0; i < treasures.length; i++){
            if(treasures[i].getPosition().getCol() == position.getCol() &&
            treasures[i].getPosition().getRow() == position.getRow() && treasures[i].getCheck() == 1){
                return treasures[i].getScore();
            }
        }
        return 0;
    }
    public void update(Position position){
        this.treasures_been_found++;
        if(this.treasures_been_found == this.treasures.length){
            this.setActive(false);
        }
    }
}