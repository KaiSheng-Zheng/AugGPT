public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive = true;
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
    }

    public int hasTreasure(Position pos) {
        for (int i = 0; i < treasures.length; i++) {
            Position pos2 = treasures[i].getPosition();
            if (pos2.equals(pos)) {
                return treasures[i].getScore();
            }
        }
        return 0;
    }

    public void update(Position pos) {
        for (int i = 0; i < treasures.length; i++) {
            Position pos2 = treasures[i].getPosition();
            if (pos2.equals(pos)) {
                Position pos1 = new Position(-1, -1);
                treasures[i] = new Treasure(0, pos1);
            }
        }
        int sum = 0;
        for (int i = 0; i < treasures.length; i++) {
            Treasure t = treasures[i];
            sum += t.getScore();
        }
        if (sum == 0) {
            isActive = false;
        }
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