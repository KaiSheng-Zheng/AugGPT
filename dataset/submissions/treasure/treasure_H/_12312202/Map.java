public class Map {
    private final int rows;

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public boolean isActive() {
        return isActive;
    }

    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private int tot;
    private int[][] map;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        map = new int[rows][columns];
        tot = treasures.length;
        for (int i = 0; i < tot; i++)
            map[treasures[i].getPosition().getRow()][treasures[i].getPosition().getCol()] = treasures[i].getScore();
        if (tot == 0) isActive = false;
        else isActive = true;
    }

    public int hasTreasure(Position position) {
        return map[position.getRow()][position.getCol()];
    }

    public void update(Position position) {
        map[position.getRow()][position.getCol()] = 0;
        tot--;
        if (tot == 0) isActive = false;
    }
}
