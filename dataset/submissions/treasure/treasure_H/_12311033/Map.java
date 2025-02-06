public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public Map(int rows, int cols, Treasure[] treasures){
        this.rows = rows;
        this.columns = cols;
        this.treasures = treasures;
        this.isActive = true;
    }
    public int getRows(){
        return this.rows;
    }
    public int getColumns(){
        return this.columns;
    }
    public int hasTreasure(Position position){
        for(Treasure i: treasures){
            if(i.canOccupy() && i.getPosition().equals(position)){
                return i.getScore();
            }
        }
        return 0;
    }
    public void update(Position position){
        for(int i = 0; i < treasures.length; i++){
            if(treasures[i].getPosition().equals(position)){
                treasures[i].setFlag();
            }
        }
        for(Treasure i: treasures){
            if(i.canOccupy()){
                return;
            }
        }
        this.isActive = false;
    }
    public boolean isActive(){
        return isActive;
    }
}
