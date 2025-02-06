public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private int[] used;
    private int cnt, now;

    public Map (int rows, int columns, Treasure[] treasures) {
        this.rows = rows - 1;
        this.columns = columns - 1;
        this.treasures = treasures;
        this.isActive = true;

        this.cnt = 0;
        this.now = 0;
        for(Treasure t : treasures) cnt++;
        this.used = new int[cnt + 1];
        for(int i = 0; i < cnt; i++) this.used[i] = 0;
    }

    public int hasTreasure(Position position) {
        for(int i = 0; i < cnt; i++){
            if(used[i] == 1) continue;
            if(treasures[i].getPosition().equals(position)) return treasures[i].getScore();
        }
        return 0;
    }

    public void update(Position position){
        for(int i = 0; i < cnt; i++){
            if(!treasures[i].getPosition().equals(position)) continue;
            if(used[i] == 0){
                used[i] = 1;
                now++;
                if(now == cnt) this.isActive = false;
            }
        }
    }

    public boolean isActive() { return this.isActive; }
    public boolean getIsActive () { return this.isActive; }
    public int getRows() { return this.rows; }
    public int getColumns() { return this.columns; }
}