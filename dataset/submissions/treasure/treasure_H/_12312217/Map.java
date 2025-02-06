public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private int treasuresNumber=0;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
        treasuresNumber=treasures.length;
    }
    public int hasTreasure(Position position){
        int equal=0;
        int theScore=0;
        for (int i = 0; i < treasures.length; i++) {
            if(position.equals(treasures[i].getPosition())){
                equal++;
                theScore=treasures[i].getScore();
                break;
            }
        }
        if(equal!=0){
            return theScore;
        }else {
            return 0;
        }
    }
    public void update(Position position){
        for (int i = 0; i <treasures.length ; i++) {
            if(position.equals(treasures[i].getPosition())){
                delete(treasures,i);
                treasuresNumber--;
            }
        }
    }
    public void delete(Treasure[] treasures,int i){
       treasures[i].setScore(0);
    }
    public boolean isActive(){
        if(this.treasuresNumber==0){
            return false;
        }else {
            return true;
        }
    }
    public int getRows(){
        return this.rows;
    }
    public int getColumns(){
        return this.columns;
    }

    public int getTreasuresNumber() {
        return treasuresNumber;
    }
}
