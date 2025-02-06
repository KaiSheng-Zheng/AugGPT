public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public boolean isActive() {
        return isActive;
    }

    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
        this.isActive = true;
    }
    public int hasTreasure(Position position) {
        for (Treasure treasure :treasures){
            if (position.getCol() == treasure.getPosition().getCol()&&position.getRow()==treasure.getPosition().getRow()&&treasure.getTrytime()!=0)
                return treasure.getScore();
        }
        return 0;
    }
    public void update(Position position){
        int size = 0;
        for (int i = 0;i<treasures.length;i++){
            if (position.getRow() == treasures[i].getPosition().getRow()&&position.getCol()==treasures[i].getPosition().getCol()){
                treasures[i].setTrytime(0);
            }
        }for (Treasure treasure :treasures){
            if (treasure.getTrytime() != 0)
                size++;
        }if (size == 0)
            isActive = false;
    }
}
