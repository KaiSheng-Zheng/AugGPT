public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public Map (int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        isActive = true;
        this.treasures = treasures;
    }

    public int hasTreasure (Position position) {
        for (int i = 0; i < treasures.length; ++i) {
            if (treasures[i] != null){
                if (treasures[i].getPosition().getRow() == position.getRow() && treasures[i].getPosition().getCol() == position.getCol()) {
                    return treasures[i].getScore();
                }
            }
        }
        return 0;
    }

    public void update (Position position) {
        boolean flg = true;
        for (int i = 0; i < treasures.length; ++i) {
            if (treasures[i] != null){
                if (treasures[i].getPosition().getRow() == position.getRow() && treasures[i].getPosition().getCol() == position.getCol()) {
                    treasures[i] = null;
                } else {
                    flg = false;
                }
            }
        }
        if (flg) isActive = false;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
