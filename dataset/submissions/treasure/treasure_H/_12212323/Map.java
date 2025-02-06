public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private Treasure[] treasuresX;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
        isActive=true;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public int hasTreasure(Position pos){
        int val=0;
        for (int i = 0; i < treasures.length; i++) {
            if(treasures[i].getPos().equals(pos)){
                val=treasures[i].getScore();
                break;
            }
        }
        return val;
    }
    public void update(Position pos) {
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getPos().equals(pos)) {
                Treasure[] treasures1 = new Treasure[treasures.length - 1];
                for (int j = 0; j < treasures1.length; j++) {
                    if (j < i) {
                        treasures1[j] = treasures[j];
                    } else {
                        treasures1[j] = treasures[j+ 1];
                    }
                }
                treasuresX=treasures1;
                break;
            }else{
                treasuresX=treasures;
            }
        }
        this.treasures=treasuresX;
    }
    public boolean isActive(){
        if(treasures.length==0){
            isActive=false;
        }
        return isActive;
    }
}
