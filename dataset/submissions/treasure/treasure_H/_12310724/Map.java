public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;this.columns=columns;this.treasures=treasures;
    }

    public int hasTreasure(Position position){
        for(int i=0;i<treasures.length;++i){
            Treasure tmp=treasures[i];
            if(tmp.getPosition().equals(position)){
                if(tmp.getVis()==false){
                    return tmp.getScore();
                }

            }
        }
        return 0;

    }
    public void update(Position position){
        for(int i=0;i<treasures.length;++i){
            Treasure tmp=treasures[i];
            if(tmp.getPosition().equals(position)){
                tmp.setVis();
            }
        }
    }
    public boolean isActive(){
        for(int i=0;i<treasures.length;++i){
            Treasure tmp=treasures[i];
            if(tmp.getVis()==false){
                return true;
            }
        }
        return false;
    }
    public int Getrows(){return rows;}
    public int Getcols(){return columns;}
}
