public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private final int[][] map;
    private int totalScore;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.isActive = true;
        this.treasures = treasures;
        this.map = new int[rows][columns];
        for (int i = 0; i < treasures.length; i++) {
            map[treasures[i].getPosition().getRow()][treasures[i].getPosition().getCol()] = treasures[i].getScore();
            totalScore += treasures[i].getScore();
        }
        this.isActive = true;
        // this.print();
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public int hasTreasure(Position position) {
        return map[position.getRow()][position.getCol()];
    }

    public void update(Position position) {
        if (isActive) {
            totalScore -= map[position.getRow()][position.getCol()];
            map[position.getRow()][position.getCol()] = 0;

            if (totalScore == 0) {
                isActive = false;
            }
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

    public void print() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
