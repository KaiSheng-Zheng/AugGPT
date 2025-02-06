public class Map {
    private int rows;
    private int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public Map(){}
    public boolean isActive(){
        return isActive;
    }
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        int n = treasures.length;
        if(n==0){
            this.isActive = false;
        }else{
            this.isActive = true;
//            for(int i=0;i<n;++i){
//                this.treasures[i] = treasures[i];
//            }
        }
    }
    public void set(int rows, int columns, Treasure[] treasures){
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        int n = treasures.length;
        if(n==0){
            this.isActive = false;
        }else{
            this.isActive = true;
//            for(int i=0;i<n;++i){
//                this.treasures[i] = treasures[i];
//            }
        }
    }
    public int hasTreasure(Position position){
        int n = treasures.length;
        for(int i=0;i<n;++i){
            if(position.equals(treasures[i].getPosition())){
                if(treasures[i].vis) return 0;
                return treasures[i].getScore();
            }
        }
        return 0;
    }
    public boolean getIsActive(){
        return isActive;
    }
    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public void update(Position position){
        isActive = false;
        int n = treasures.length;
        for(int i=0;i<n;++i){
            if(position.equals(treasures[i].getPosition())){
                treasures[i].vis = true;
            }
            if(!treasures[i].vis) isActive = true;
        }
    }
}
