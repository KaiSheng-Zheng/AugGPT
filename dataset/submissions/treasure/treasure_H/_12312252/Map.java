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

    public int hasTreasure(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (position.equals(this.treasures[i].getPosition()))
                return treasures[i].getScore();
        }
        return 0;
    }

    public void update(Position position) {
        for (int i = 0; i < this.treasures.length; i++) {
            if (position.equals(this.treasures[i].getPosition())) {
                Treasure[] treasures = new Treasure[this.treasures.length - 1];
                System.arraycopy(this.treasures, 0, treasures, 0, i);
                System.arraycopy(this.treasures, i + 1, treasures, i, this.treasures.length - i - 1);
                this.treasures = treasures;
            }
            if (treasures.length == 0)
                isActive = false;
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