public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive=true;
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    public boolean getIsActive(){
        return isActive;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public void setTreasures(Treasure[] treasures) {
        this.treasures = treasures;
    }

    public String toString() {
        return "Map{rows = " + rows + ", columns = " + columns + ", isActive = " + isActive + ", treasures = " + treasures + "}";
    }

    public int hasTreasure(Position position){
        for(int i=0;i<treasures.length;i++){
            if(treasures[i]!=null && position.equals(treasures[i].getPosition())){
                return treasures[i].getScore();
            }
        }
        return 0;
    }

    public void update(Position position){
        int a=hasTreasure(position);
        if(a!=0){
            for(int i=0;i<treasures.length;i++){
                if(treasures[i]!=null && position.equals(treasures[i].getPosition())){
                    treasures[i]=null;
                    break;
                }
            }
        }
        for(int i=0;i<treasures.length;i++){
            if(treasures[i]!=null){
                break;
            }
            if(i==treasures.length-1){
                isActive=(1==2);
            }
        }
    }
}
