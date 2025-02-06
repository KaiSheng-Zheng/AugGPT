public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public void setTreasures(Treasure[] A){
        treasures=A;
    }
    public int getRows(){
        return rows;
    }
    public int getColumns(){
        return columns;
    }
    public Treasure[] getTreasures(){
        return treasures;
    }
    public Map(int rows,int columns,Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
    }

    public int hasTreasure(Position position){
        for(int i=0;i<treasures.length;i++){
            if(treasures[i].getPosition().equals(position)){
                return treasures[i].getScore();
            }
        }
        return 0;
    }

    public void update(Position position){
        Treasure[] treasuresNew=new Treasure[treasures.length-1];
        int i=0;
        while(i<treasures.length&&!treasures[i].getPosition().equals(position)) {
            i++;
        }
        if(i>=0&&i<treasures.length) {
            for (int k = 0; k < i; k++) {
                treasuresNew[k] = treasures[k];
            }
            for (int k = i + 1; k < treasures.length; k++) {
                treasuresNew[k - 1] = treasures[k];
            }
            setTreasures(treasuresNew);
        }else treasures=treasures;
    }

    public boolean isActive() {
        if(treasures.length!=0){
            return true;
        }else return false;
    }
}
