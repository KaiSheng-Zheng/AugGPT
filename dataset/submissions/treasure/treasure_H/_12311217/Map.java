public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive=true;
    private Treasure[] treasures;
    private  int cnt=0;

    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
    }

    public int hasTreasure(Position position){
        for (int i = 0; i < treasures.length; i++) {
            if(treasures[i].getPosition().equals(position)){
                return treasures[i].getScore();
            }
        }
        return 0;
    }
    public void update(Position position){
        int length=treasures.length;
        for (int i = 0; i < treasures.length; i++) {
            if(treasures[i].getPosition().equals(position)&&treasures[i].getScore()!=0){
              treasures[i]=new Treasure(0,treasures[i].getPosition());
              cnt++;
            }
            if(cnt==length){
                isActive=false;
            }
        }
    }

    public boolean isActive() {
        return isActive;
    }



    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }


}
