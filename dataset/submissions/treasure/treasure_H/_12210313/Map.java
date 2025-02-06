public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;}
    public int getRows(){return rows;}
    public int getColumns(){return columns;}
    public int hasTreasure(Position position){
        for (Treasure treasure : treasures) {
            if (position.getCol() == treasure.getPosition().getCol() && position.getRow() == treasure.getPosition().getRow()) {
                return treasure.getScore();}}return 0;}
    public void update(Position position){
        for (Treasure treasure : treasures) {
            if (position.getCol() == treasure.getPosition().getCol() && position.getRow() == treasure.getPosition().getRow()) {
                treasure.setExist(-1);
                }}
    }
    public boolean hasExist(Position position){
        for (Treasure treasure : treasures) {
            if (position.getCol() == treasure.getPosition().getCol() && position.getRow() == treasure.getPosition().getRow()) {
                if(treasure.getExist() == -1){
                    return false;
                }
            }}
        return true;
    }
    public boolean isActive(){
         int count = 0;
        for (Treasure treasure : treasures) {
            if (treasure.getExist() == -1){
                count++;}}
        isActive = count != treasures.length;
        return isActive;}
}