public class Map {
    private final int tot, rows, columns;
    private boolean isActive;
    private int lost;
    private boolean[] vis;
    private final Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        tot = treasures.length;
        vis = new boolean[tot];
        lost = 0;
        for(int i = 0; i < tot; i ++) vis[i] = true;
        isActive = true;
    }
    public int hasTreasure(Position position) {
        int ans = 0;
        for(int i = 0; i < tot; i ++)
            if(vis[i] && treasures[i].getPosition().equals(position))
                ans = treasures[i].getScore();
        return ans;
    }
    public void update(Position position) {
        for(int i = 0; i < tot; i ++)
            if(vis[i] && treasures[i].getPosition().equals(position)) {
                lost ++;
                vis[i] = false;
            }
        if(lost == tot) isActive = false;
    }
    public int getColumns() { return columns; }

    public int getRows() { return rows; }
    public boolean isActive() { return isActive; }
}
