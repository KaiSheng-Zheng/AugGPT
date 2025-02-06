public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
        this.isActive=true;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int hasTreasure(Position position){
        for(Treasure a : treasures){
            if(a.getPosition().equals(position)){
                return a.getScore();
            }
        }
        return 0;
    }
    public void update(Position position){
        for(Treasure a : treasures){
            if(a.getPosition().equals(position)){
                a.getPosition().setCol(-1);
                a.getPosition().setRow(-1);
            }
        }

    }
    public boolean isActive(){
        for(Treasure a : treasures){
            if(a.getPosition().getCol()!=-1&&a.getPosition().getRow()!=-1){
                return true;
            }
        }
        return false;
    }
    public boolean getIsActive(){
        for(Treasure a : treasures){
            if(a.getPosition().getCol()!=-1&&a.getPosition().getRow()!=-1){
                return true;
            }
        }
        return false;
    }
}
