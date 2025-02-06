public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
    }

    public int hasTreasure(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (position.equals(treasures[i].getPosition()) && treasures[i].isFlag()) {
                return treasures[i].getScore();
            }
        }
        return 0;
    }

    public void update(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (position.equals(treasures[i].getPosition())/*&&treasures[i].isFlag()*/) {
                treasures[i].setFlag(false);
                break;
            }
        }
    }

    public boolean isActive() {
        isActive = false;
        for (Treasure i : treasures) {
            if (i.isFlag()) {
                isActive = true;
            }
        }
        return isActive;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}