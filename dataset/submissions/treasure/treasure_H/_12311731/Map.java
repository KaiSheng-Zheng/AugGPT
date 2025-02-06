public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public Map(int rows, int columns,Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.isActive = true;
    }

    public int hasTreasure(Position position){
        for (int i = 0; i < treasures.length; i++) {
            if(treasures[i].getPosition().getRow() == position.getRow() && treasures[i].getPosition().getCol() == position.getCol()){
                return treasures[i].getScore();
            }
        }
        return 0;
    }

    public boolean isActive(){
        return isActive;
    }

    public void update(Position position){
        int check = 0;
        for (int i = 0; i < treasures.length; i++) {
            if(treasures[i].getScore() != 0){
                check++;
            }
        }
        if(check == 0){
            isActive = false;
            return;
        }
        for (int j = 0; j < treasures.length; j++) {
            if(treasures[j].getPosition().equals(position)){
               treasures[j].setScore(0);
            }
        }
    }

    public int getRows(){return rows;}
    public int getColumns(){return columns;}
    public Treasure[] getTreasures(){
        return treasures;
    }
}