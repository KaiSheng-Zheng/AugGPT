public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public Map(int rows,int columns,Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures = treasures != null ? treasures : new Treasure[0];
        this.isActive=true;
    }
    public int hasTreasure(Position position){
        for(int i =0;i<treasures.length;i++){
            if(treasures[i].getPosition().equals(position)&&treasures[i].isAvailability()){

                return treasures[i].getScore();
            }
        }
        return 0;
    }
    public void update(Position position){
        boolean activity=false;
        for(int i=0 ;i<treasures.length;i++){
            if(treasures[i].getPosition().equals(position)&&treasures[i].isAvailability()){
                treasures[i].treasureFound();
            }
        }
        for(int i =0;i<treasures.length;i++){
            activity=treasures[i].isAvailability();
            if(activity){break;}
        }
        isActive =activity;

    }
    //public boolean getisActive(){return isActive;}

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public boolean isActive() { return isActive;
    }
}