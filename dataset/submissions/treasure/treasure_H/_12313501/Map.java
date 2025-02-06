public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive=true;

    public boolean isActive() {
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].isac==true) {
                isActive=true;
                return true;
            }
        }
        isActive=false;
        return false;
    }

    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public int hasTreasure(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getPosition().getRow() == position.getRow() && treasures[i].getPosition().getCol() == position.getCol()) {
                if (treasures[i].isac) {
                    return treasures[i].getScore();
                } else {
                    return 0;

                }
            }
        }
        return 0;
    }

    public void update(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getPosition().getRow() == position.getRow() && treasures[i].getPosition().getCol() == position.getCol()) {
                treasures[i].isac = false;
            }
        }

    }
}
