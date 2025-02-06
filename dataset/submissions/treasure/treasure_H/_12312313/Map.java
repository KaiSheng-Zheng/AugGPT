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

    public int hasTreasure(Position position){
        for(Treasure i:treasures){
            if(position.equals(i.getPosition()) && i.ifzero){
                return i.getScore();
            }
        }
        return 0;
    }

    public void update(Position position){
        for(Treasure i:treasures){
            if(position.equals(i.getPosition()) && i.ifzero){
                i.ifzero=false;
            }
            this.isActive();
        }
    }
    public boolean isActive(){
        for(Treasure i:treasures){
            if(i.ifzero){
                isActive=true;
                return true;
            }
        }
        this.isActive=false;
        return false;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
