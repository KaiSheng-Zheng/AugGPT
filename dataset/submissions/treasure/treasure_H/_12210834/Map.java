public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        isActive = true;

    }
    public int getRows() {
        return rows;
    }
    public int getColumns() {
        return columns;
    }
    public int hasTreasure(Position position){
        for(Treasure treasure : treasures){
            if(treasure!=null) {
                Position p = treasure.getPosition();
                if (p.getCol() == position.getCol() && p.getRow() == position.getRow()) {
                    return treasure.getScore();
                }
            }
        }
        return 0;
    }
    public void update(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if(treasures[i]!=null) {
                if (treasures[i].getPosition().equals(position)) {
                    treasures[i] = null;
                    break;
                }
            }
        }
        if (allTreasuresFound()) {
            isActive = false;
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean allTreasuresFound() {
        for (Treasure treasure : treasures) {
            if (treasure != null) {
                return false;
            }
        }
        return true;
    }
}