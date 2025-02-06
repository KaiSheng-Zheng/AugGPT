public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures){
        this.columns=columns;
        this.treasures=treasures;
        this.rows=rows;
    }
    public int hasTreasure(Position position){
        int s=0;
        for(int i=0;i<treasures.length;i++){
            if(position.getCol()==treasures[i].getPosition().getCol()&&position.getRow()==treasures[i].getPosition().getRow()){
                s=treasures[i].getScore();
            }
        }return s;
    }
    public void update(Position position){
        for(int i=0;i<treasures.length;i++){
            if(position.getCol()==treasures[i].getPosition().getCol()&&position.getRow()==treasures[i].getPosition().getRow()){
                treasures[i].setScore(0);
            }
        }
    }
    public boolean isActive(){
        int n=0;
        for(int i=0;i<treasures.length;i++){
            if(treasures[i].getScore()==0){
                n++;
            }
        }if(n==treasures.length){
            isActive= false;
        }else isActive= true;
        return isActive;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }
}
