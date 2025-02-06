public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[]treasures;
    public Map(int rows,int columns,Treasure[]treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
        this.isActive=true;
    }
    public int hasTreasure(Position pos){
        for(int i=0;i<treasures.length;i++){
            if((treasures[i] != null) && treasures[i].getPos().equals(pos)){
                int score=treasures[i].getScore();
                return score;
            }
        }
        return 0;
    }
    public void update(Position pos){
        for (int i = 0; i < treasures.length; i++) {
            if((treasures[i] != null) && treasures[i].getPos().equals(pos)){
                treasures[i]=null;
            }
        }
    }
    public boolean isActive(){
        isActive=false;
        for(int i=0;i<treasures.length;i++){
            if(treasures[i]!=null){
                isActive=true;
            }
        }
        return isActive;
    }

}
