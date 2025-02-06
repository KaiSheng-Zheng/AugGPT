public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows= rows;
        this.columns=columns;
        this.treasures=treasures;
    }
    public int hasTreasure(Position position){
        int score =0;
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getPosition().equals(position) && treasures[i].isIsactive()){
                score= treasures[i].getScore();
                
            }
        }
        return score;
    }
    public int getTreasure(Position position){
        int score =0;
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getPosition().equals(position) && treasures[i].isIsactive()){
                score= treasures[i].getScore();
                treasures[i].setIsactive(false);
            }
        }
        return score;
    }

    public void update(Position position){
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getPosition().equals(position)){
                treasures[i].setIsactive(false);
            }
        }
    }
    public boolean isActive(){
        int truenum = 0;
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].isIsactive()){
                truenum++;
            }
        }
        if (truenum>0){
            return true;
        }else  return false;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
