public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive=true;
    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;this.columns=columns;this.treasures=treasures;
    }
    public int hasTreasure(Position position){
        for(int i=0;i<treasures.length;i++){
            if(position.equals(treasures[i].getPosition())){
                return treasures[i].getScore();
            }
        }
        return 0;
    }
    public void update(Position position){
        for(int i=0;i<treasures.length;i++){
            if(position.equals(treasures[i].getPosition())){
                treasures[i]=new Treasure(0,new Position(position.getRow(),position.getCol()));
            }
        }
        int cnt=0;
        for(int i=0;i<treasures.length;i++){
            if(treasures[i].getScore()==0){
                cnt++;
            }
        }
        if(cnt==treasures.length){
            isActive=false;
        }
        else{
            isActive=true;
        }
    }
    public Treasure[] getTreasures(){
        return treasures;
    }
    public int getRows() {
        return rows;
    }
    public int getColumns() {
        return columns;
    }
    public boolean isActive(){
        int cnt=0;
        for(int i=0;i<treasures.length;i++){
            if(treasures[i].getScore()==0){
                cnt++;
            }
        }
        if(cnt==treasures.length){
            isActive=false;
        }
        else{
            isActive=true;
        }
        return isActive;
    }
    public boolean getIsActive(){
        return isActive;
    }
}
