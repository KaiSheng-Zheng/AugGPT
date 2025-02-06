public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive() {
        isActive = false;
    }

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.isActive = true;
        this.treasures = treasures;
    }

    public int hasTreasure(Position position) {
        for (Treasure treasure : treasures) {
            if (treasure.getPosition().equals(position) && !treasure.isFounded()) {
                return treasure.getScore();
            }
        }
        return 0;
    }

    public void update(Position position) {
        for (Treasure treasure : treasures) {
            if (treasure.getPosition().equals(position) && !treasure.isFounded()) {
                treasure.setFounded();
                return;
            }
        }
    }

    public void checkActive() {
        for (Treasure treasure : treasures) {
            if (!treasure.isFounded()) return;
        }
        setActive();
    }
}
