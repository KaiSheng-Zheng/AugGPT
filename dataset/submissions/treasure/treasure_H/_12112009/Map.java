public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows-1;
        this.columns=columns-1;
        this.treasures=treasures;
    }

    public int getrows(){
        return rows;
    }
    public int getcols(){
        return columns;
    }
    public int hasTreasure(Position position){
        for(int i=0;i<treasures.length;i++) {
            if (position.equals(treasures[i].getPosition())) {
                if (treasures[i].getboo()) {
                    return treasures[i].getScore();
                }
            }
        }
            return 0;
        }
    public void update(Position position){
        for(int i=0;i<treasures.length;i++){
            if(position.equals(treasures[i].getPosition())){
                treasures[i].setboo(false);
            }
        }
        }

    public boolean isActive(){
        for(int i=0;i<treasures.length;i++){
            if(treasures[i].getboo()){
                return true;
            }
        }
        return false;
    }
}