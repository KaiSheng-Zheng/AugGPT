public class Map {

    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    private int findNumber=0;

    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
    }
    public int hasTreasure(Position position){
        for (int i=0;i<treasures.length;i++){
            if(position.equals(treasures[i].getPosition())){
                return treasures[i].getScoreoftreasures();
            }
        }
        return 0;
    }
    public int hasTreasure2(Position position){
        for (int i=0;i<treasures.length;i++){
            if(position.equals(treasures[i].getPosition())){
                int a=treasures[i].getScoreoftreasures();
                if(treasures[i].getScoreoftreasures()!=0){
                    findNumber++;}
                treasures[i]=new Treasure(0,treasures[i].getPosition());
                update();
                return a;
            }
        }
        return 0;
    }


    public void update(Position position){
        for (int i=0;i<treasures.length;i++) {
            if(position.equals(treasures[i].getPosition())) {
                if(treasures[i].getScoreoftreasures()!=0){
                    findNumber++;}
                    treasures[i] = new Treasure(0, treasures[i].getPosition());
            }
        }
    }
private void update(){
        Map map = new Map(rows, columns, treasures);
    }
    public int getRows(){
        return this.rows;
    }
    public  int getColumns(){
        return  this.columns;
    }
    public boolean isActive(){
        if(treasures.length==findNumber){
            return false;
        }else {
            return true;
        }
    }
}
