public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private boolean[] removed;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.isActive = true;
        this.treasures = treasures;
        this.removed = new boolean[treasures.length];
    }

    public int hasTreasure(Position position) {
        if (!isActive)
            return 0;
        for (int i = 0; i < treasures.length; ++i) {
            if (removed[i])
                continue;
            if (position.equals(treasures[i].getPosition()))
                return treasures[i].getScore();
        }
        return 0;
    }

    public void update(Position position) {
        if (!isActive)
            return;
        isActive = false;
        for (int i = 0; i < treasures.length; ++i) {
            if (position.equals(treasures[i].getPosition()))
                removed[i] = true;
            else if (!removed[i])
                isActive = true;
        }
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
}
