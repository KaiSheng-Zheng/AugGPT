public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        isActive=true;
    }
    public int hasTreasure(Position position){
        for (int i = 0; i < treasures.length; i++) {
            if(treasures[i].getPosition().getRow()== position.getRow()&&treasures[i].getPosition().getCol()== position.getCol()&&treasures[i].getPosition().state){
                int score=treasures[i].getScore();
                position.changeStatus();
                return score;
            }
        }
        return 0;
    }
    public void update(Position position){
        boolean flag=true;
        for (int i = 0; i < treasures.length; i++) {
           if(treasures[i].getPosition().state){
               if(treasures[i].getPosition().getRow()== position.getRow()
               &&treasures[i].getPosition().getCol()== position.getCol()){
                   treasures[i].getPosition().changeStatus();
               }else{
                   flag=false;
               }
            }
        }
        if(flag){
            isActive=false;
        }
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
}
