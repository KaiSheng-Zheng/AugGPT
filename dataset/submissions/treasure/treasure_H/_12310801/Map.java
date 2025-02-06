public class Map {
    private final int rows, columns;
    private int tot;
    private boolean isActive;
    private int[][] score;
    private final Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        tot = treasures.length;
        score = new int[rows][columns];
        for(int i = 0; i < tot; i ++)
            score[treasures[i].getPosition().getRow()][treasures[i].getPosition().getCol()] = treasures[i].getScore();
        isActive = true;
    }
    public int hasTreasure(Position position) {
        return score[position.getRow()][position.getCol()];
    }
    public void update(Position position) {
        if(score[position.getRow()][position.getCol()] == 0) return ;
        score[position.getRow()][position.getCol()] = 0;
        tot --;
        if(0 == tot) isActive = false;
    }
    public int getColumns() { return columns; }

    public int getRows() { return rows; }
    public boolean isActive() { return isActive; }
}
