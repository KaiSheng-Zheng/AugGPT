public class Map{
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        isActive = true;
    }

    public int hasTreasure(Position position){
        for (Treasure t : treasures){
            if (t.getPosition().equals(position)){
                return t.getScore();
            }
        }
        return 0;
    }
    public void update(Position position){
        int c = 0;
        for (Treasure t : treasures){
            if (t.getPosition().equals(position)){
                treasures = rmvTreasure(treasures,c);
                break;
            }
            c++;
        }
        isActive();
    }
    public Treasure[] rmvTreasure(Treasure[] T,int c){
        Treasure[] R = new Treasure[T.length - 1];
        System.arraycopy(T, 0, R, 0, c);
        System.arraycopy(T, c + 1, R, c, treasures.length - c - 1);
        return R;
    }
    public boolean isActive(){
        if (treasures != null && treasures.length > 0){
            return true;
        }else {
            return false;
        }
    }
    public int getColumns() {
        return columns;
    }
    public int getRows() {
        return rows;
    }
}