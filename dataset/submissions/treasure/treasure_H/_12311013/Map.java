
public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive=true;
    private Treasure[] treasures;
    public Position zancun;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
        this.zancun=new Position(-1,-1);
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

    public Treasure[] getTreasures() {
        return treasures;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int hasTreasure(Position position){
        for (int i = 0; i < treasures.length; i++) {

            if(position.equals(treasures[i].getPosition())){
                int m =treasures[i].getScore();
                zancun=position;
                return m;
            }
        }
        return 0;
    }
    public void update(Position position){
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getPosition().equals(position)&&treasures[i].getScore()!=0){
                //treasures[i].ssetScore(0);
                treasures[i]=new Treasure(0,treasures[i].getPosition());

            }
        }
        step:{
        for (int i = 0; i < treasures.length; i++) {
            if(treasures[i].getScore()!=0){
                break step;
            }
        }isActive=false;}
    }
}
