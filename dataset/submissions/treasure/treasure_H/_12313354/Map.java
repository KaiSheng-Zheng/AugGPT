
public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure [] treasures ;

    public Map(int rows, int columns,Treasure []treasures ) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures ;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
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
        for (Treasure t : treasures) {
            if (t.getPosition().equals(position)) {
                return t.getScore();
            }
        }
        return 0;
    }

    public void update(Position position){
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getPosition().equals(position)) {
                treasures[i] = null;
            }
        }
    }

    public boolean isActive(){
        for (Treasure t : treasures) {
            if (t != null) {
                return true;
            }
        }
        return false;
    }
    public boolean isValidPosition(Position position) {
        int row = position.getRow();
        int col = position.getCol();

        return row >= 0 && row < rows && col >= 0 && col < columns;
    }
}
