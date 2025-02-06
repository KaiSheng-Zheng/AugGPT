public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.isActive = true;
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

    public int hasTreasure(Position position){
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i] != null){
                if (treasures[i].getPosition().equals(position)){
                    return treasures[i].getScore();
                }
            }
        }
        return 0;
    }

    public void update(Position position){
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i] != null){
                if (treasures[i].getPosition().equals(position)){
                    treasures[i] = null;
                }
            }
        }
    }

    public boolean checkActive(Treasure[] treasures){
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i] != null){return true;}
        }
        return false;//no treasures
    }
}