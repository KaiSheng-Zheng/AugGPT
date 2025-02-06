public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
    }
    public int hasTreasure(Position pos){
        int score;
        for(int i=0;i<treasures.length;i++){
            if(pos==treasures[i].getPos()){
                score=treasures[i].getScore();
                Treasure[] newTreasures = new Treasure[treasures.length - 1];
                int count = 0;
                for (int i2=0;i2<treasures.length-1;i2++) {
                    if (count!=i) {
                        newTreasures[i2] = treasures[count];
                    }
                    count++;
                }
                treasures = newTreasures;
                return score;
            }

        }
         return 0;
    }
    public void update(Position pos){}
    public boolean isActive() {
        if(treasures.length==0){
            return false;
        }
        return true;
    }

    public int getColumns() {
        return columns;
    }
    public int getRows() {
        return rows;
    }
    public Treasure[] getTreasures() {
        return treasures;
    }
}
