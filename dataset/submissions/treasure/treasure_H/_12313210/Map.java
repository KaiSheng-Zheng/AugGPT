

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive=true;
    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
    }

    public int hasTreasure(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getPosition().equals(position)) {
                return treasures[i].getScore();
            }
        }
        return 0;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void update(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getPosition().equals(position)) {
                treasures[i].setScore(0);
                treasures[i].isActive=false;
            }
        }
    }

    public boolean isActive() {
        for (Treasure treasure : treasures) {
            if (treasure.isActive) {
                this.isActive = true;
                return true;
            }
        }
        this.isActive=false;
        return false;
    }
}
