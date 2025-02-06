public class Map {
    int rows;
    int columns;
    private boolean isActive;
    Treasure[] treasures;

    public Map(int rows, int columns,Treasure[]treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures=treasures;
    }
    private int cs=0;
    public int hasTreasure(Position pos){
        int b=0,c=-1;
        if (cs==0) {
            for (int i = 0; i < treasures.length; i++) {
                if (pos.equals(treasures[i])) {
                    b=treasures[i].score;
                    c=i;
                    treasures[i].score=0;
                }
            }
        }else{
            for (int i = 0; i < treasures.length-cs; i++) {
                if (pos.equals(treasures[i])) {
                    b=treasures[i].score;
                    c=i;
                    treasures[i].score=0;
                }
            }
        }
        if (c>=0) {
            cs+=1;
            for (int i = c; i < treasures.length - cs; i++) {
                treasures[i]=treasures[i+1];
            }
        }
        return b;
    }
    public boolean isActive(){
        if (cs>=treasures.length) {
            return false;
        }else return true;
    }
}
