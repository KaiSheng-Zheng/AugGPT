public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private final Treasure[] treasures;
    int num=0;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
//        this.treasures=new Treasure[treasures.length];
//        System.arraycopy(treasures, 0, this.treasures, 0, treasures.length);
        this.treasures=treasures;
        isActive=treasures.length!=0;
    }

    public int hasTreasure(Position position){
        for (Treasure treasure : treasures) {
            if (treasure.getPosition().equals(position)) {
                return treasure.getScore();
            }
        }
        return 0;
    }
    public void update(Position position){
        for(Treasure treasure:treasures){
            if(treasure.getPosition().equals(position)){
                treasure.setPosition(-1,-1);
                num++;
                if(num==treasures.length) isActive=false;
                return;
            }
        }
    }
    public boolean isActive(){
        return isActive;
    }
    public boolean hav(int x,int y){
        return (x>=0&&x<rows)&&(y>=0&&y<columns);
    }
}
