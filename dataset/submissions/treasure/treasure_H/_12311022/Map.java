

public class Map {
    private final int rows;
    private final int columns;

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    private boolean isActive;
    private int usedTime=0;
    private Treasure[] treasures;
    public Map(int rows,int columns,Treasure[] treasures){
        this.columns=columns;
        this.rows=rows;
        this.treasures=treasures;
    }
    public int hasTreasure(Position position){
        int getScore=0;
        for(int i=0;i<treasures.length;i++){
            if(position.equals(treasures[i].getPosition()) && treasures[i].getUsedTime()==0){
                getScore=treasures[i].getScore();
                break;
            }
        }
        return getScore;
    }
    public void update(Position position){
        for(int i=0;i<treasures.length;i++){
            if(position.equals(treasures[i].getPosition()) && treasures[i].getUsedTime()==0){
                treasures[i].getUsed();
                usedTime++;
            }
            }
    }
    public boolean isActive(){
        return usedTime < treasures.length;
    }
}
