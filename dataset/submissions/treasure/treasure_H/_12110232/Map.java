public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.isActive = true;
        this.treasures = treasures;
    }

    public int hasTreasure(Position position) {
        for (Treasure treasure : treasures) {
            if (treasure == null) {
                continue;
            }
            if (treasure.getPosition().equals(position)) {
                return treasure.getScore();
            }
        }
        return 0;
    }

    public void update(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i] == null) {
                continue;
            }
            if (treasures[i].getPosition().equals(position)) {
                treasures[i] = null;
                break;
            }
        }
    }

    public boolean isActive() {
        isActive = false;
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i] != null) {
                isActive = true;
                break;
            }
        }
        return isActive;
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return columns;
    }
}
