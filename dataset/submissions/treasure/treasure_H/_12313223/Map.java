public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive=true;
    private Treasure[] treasures;
    private int n;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
        n=treasures.length;
        if(n==0) isActive=false;
        else isActive=true;
    }
    public int hasTreasure(Position position){
        for(int i=0;i<n;i++){
            if(position.equals(treasures[i].getPosition())) return treasures[i].getScore();
        }
        return 0;
    }
    public void update(Position position){
        int x=0;
        for(int i=0;i<n;i++){
            if(position.equals(this.treasures[i].getPosition())){
                x=i;
                break;
            }
        }
        for(int i=x;i+1<n;i++){
            this.treasures[i]=this.treasures[i+1];
        }
        n--;
        if(n==0) isActive=false;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean pd(int x,int y){
        if(x<0) return false;
        if(x>=this.rows) return false;
        if(y<0) return false;
        if(y>=this.columns) return false;
        return true;
    }
}
