public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive=true;
    private Treasure[] treasures;
    private int treasuresleft;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
        this.treasuresleft=treasures.length;
    }
    public int hasTreasure(Position position,int aaaa){
        for (int i = 0; i < treasures.length; i++) {
            if (position.equals(treasures[i].getPosition())&&treasures[i].getScore()!=0&&treasures[i].isFindedornot()){
                int a=treasures[i].getScore();
                treasuresleft--;
                treasures[i].finded();
                update(position);
                return a;
            }
        }
        return 0;
    }
    public int hasTreasure(Position position){
        for (int i = 0; i < treasures.length; i++) {
            if (position.equals(treasures[i].getPosition())&&treasures[i].getScore()!=0&&treasures[i].isFindedornot()){
                return treasures[i].getScore();
            }
        }
        return 0;
    }
    public void update(Position position){
        isActive();
    }
    public boolean isActive(){
        if (treasuresleft==0) {
            isActive = false;
        } else isActive=true;
        return isActive;
    }

    public int getRows() {
        return rows;
    }
    public int getColumns() {
        return columns;
    }
    public int getTreasuresleft(){
        return treasuresleft;
    }
}