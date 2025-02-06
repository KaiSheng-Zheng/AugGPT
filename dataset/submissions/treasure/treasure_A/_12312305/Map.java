



public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasure) {
        this.rows = rows;
        this.columns = columns;
        treasures = treasure;
        isActive = true;
    }
    public int hasTreasure(Position position){
        for(int i = 0;i < treasures.length;i++){
            if(position.equals(treasures[i].getPosition())&&treasures[i].getScore()!=0){
                return treasures[i].getScore();
            }
        }
        return 0;
    }
    public void update(Position position){
        for(int i = 0;i < treasures.length;i++){
            if(position.equals(treasures[i].getPosition())){
                treasures[i].setScore(0);
            }
        }
        isActive= false;
        for(int i = 0;i<treasures.length;i++){
            if(treasures[i].getScore()!=0){
                isActive = true;
            }
        }
    }
    public boolean isActive(){
        return isActive;
    }
}
