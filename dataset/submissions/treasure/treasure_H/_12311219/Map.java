public class Map {
    
    private final int rows;

    private final int columns;
 
    private boolean isActive;
   
    private Treasure[] treasures ;


    public Map(int rows, int columns, Treasure... treasures) {
       
        this.rows = rows;
        this.columns = columns;
     
        this.treasures = treasures;

        this.isActive = true;
    }


    public int hasTreasure(Position pos) {
 

        for (int i = 0; i < treasures.length; i++) {
            if(treasures[i].getPos().equals(pos)){
                return treasures[i].getScore();
            }
        }
   
        return 0;
    }


    public void update(Position pos) {
        Treasure[] newtreasures=new Treasure[treasures.length-1];
        if(newtreasures.length>0){
            for (int i = 0; i < treasures.length; i++) {
            if(treasures[i].getPos().equals(pos)){
                for (int i1 = 0; i1 < newtreasures.length; i1++) {
                    if(i1<=i-1){
                        newtreasures[i1]=treasures[i1];
                    }else if(i1>=i){
                        newtreasures[i1]=treasures[i1+1];
                    }
                }
                this.treasures=newtreasures; }
        }}else {this.treasures=new Treasure[0];}

        if(treasures.length>0){isActive=true;}else{isActive=false;}

        }



    public Treasure[] getTreasures() {
        return treasures;
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

