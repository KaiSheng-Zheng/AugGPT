public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public Map(int rows, int columns,Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures=treasures;
        isActive=true;
    }
    public int hasTreasure(Position position){
        for(int i=0;i<treasures.length;i++){
            if(position.equals(treasures[i].getPosition())){
                if(treasures[i].available==false) return 0;
                return treasures[i].getScore();
            }
        }return 0;
    }

    public int getRows() {
        return this.rows;
    }
    public int getColumns(){
        return this.columns;
    }

    public void update(Position position){
        for(int i=0;i<treasures.length;i++){
            if(treasures[i].getPosition().equals(position)){
                treasures[i].available=false;
            }
        }
        isActive=false;
        for(int i=0;i<treasures.length;i++){
            if(treasures[i].available){
                isActive=true;
            }
        }

    }
    public boolean isActive(){
        return isActive;
    }
}
