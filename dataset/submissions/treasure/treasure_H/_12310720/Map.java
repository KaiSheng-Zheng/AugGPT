public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures){
        this.columns=columns;
        this.rows=rows;
        this.treasures =treasures;
        isActive=true;
    }
    public int hasTreasure(Position position){
        for (Treasure treasure : treasures) {
            if (treasure.getPosition().equals(position)) {
                if (treasure.isExistance()){
                return treasure.getScore();}
                else return 0;
            }
        }
        return 0;
    }
    public void update(Position position){
        for (Treasure treasure : treasures) {
        if (treasure.getPosition().equals(position)) {
            treasure.setExistance(false);
        }
    }
        int aaaa =0;
        for (Treasure treasure : treasures) {
            if (!treasure.isExistance()){
                aaaa++;
            }
            if (aaaa == treasures.length) {
                isActive = false;
                break;
            }
        }

    };
    public boolean isActive(){
        return isActive;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }
}