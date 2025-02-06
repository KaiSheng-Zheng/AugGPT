public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures.clone();
        this.isActive=true;
    }
    public int hasTreasure(Position position){
        for(Treasure treasure:treasures){
            if(treasure.getPosition().equals(position))return treasure.getScore();
        }
        return 0;
    }
    public void update(Position position){
        int i=0;
        Treasure[] temp1=new Treasure[treasures.length-1];
        if(temp1.length==0){
            isActive=false;
        }
        for(Treasure treasure:treasures){
            if(treasure.getPosition().equals(position))continue;
            temp1[i]=treasure;
            i++;
        }
        treasures=temp1;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public boolean isActive() {
        return isActive;
    }
}
