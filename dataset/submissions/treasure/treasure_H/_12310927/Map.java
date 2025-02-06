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

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        isActive=true;
    }
    public int hasTreasure(Position position){
        for(int i=0;i<treasures.length;i++){
            if(treasures[i].getPosition().equals(position)){
                if(treasures[i].isActive()){
                    return treasures[i].getScore();
                }else {
                    return 0;
                }
            }
        }
        return 0;
    }
    public void update(Position position){
        for(int i=0;i<treasures.length;i++) {
            if (treasures[i].getPosition().equals(position)) {
                treasures[i].setActive(false);
            }
        }
        int flag=0;
        for(int i=0;i<treasures.length;i++) {
            if (!treasures[i].isActive()) {
                flag++;
            }else {
                break;
            }
        }
        if(flag==treasures.length){
            isActive=false;
        }
    }
    public boolean isActive(){
        return isActive;
    }
}