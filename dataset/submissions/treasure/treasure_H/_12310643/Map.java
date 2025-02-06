public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public void setTreasures(Treasure[] treasures) {
        this.treasures = treasures;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public int getRows() {
        return rows;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public int getColumns() {
        return columns;
    }
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
        this.isActive=false;
        for(Treasure t:getTreasures()){
            if(t.getAnother()!=0)
                this.isActive=true;
        }
    }
    public int hasTreasure(Position position){
        int ret=0;
        for(Treasure t:getTreasures()){
            if(t.getPosition().equals((Object) position))
                ret=t.getAnother();
        }
        return ret;
    }
    public void update(Position position){
        for(Treasure t:getTreasures()){
            if(t.getPosition().equals(position)){
                t.setAnother(0);
            }
        }
        this.isActive=false;
        for(Treasure t:getTreasures()){
            if(t.getAnother()!=0)
                this.isActive=true;
        }
    }
    public boolean isActive(){
        boolean ret=false;
        for(Treasure t:treasures){
            if(t.getAnother()!=0)
                ret=true;
        }
        this.isActive=ret;
        return ret;
    }
}
