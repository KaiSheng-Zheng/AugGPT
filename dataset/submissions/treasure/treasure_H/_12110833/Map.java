public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;


    public Map(int rows, int columns, Treasure[] treasures){ //constructor method;
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        isActive = treasures.length > 0;
    }

    public int hasTreasure(Position position){ //hasTreasure method;
        int rescore = 0;
        for(Treasure e: treasures){
            if(position.getRow() == e.getPosition().getRow()
                    && position.getCol() == e.getPosition().getCol()){
                rescore = e.getScore();
                break;
            }
        }
        return rescore;
    }

    public void update(Position position){ //update method;
        Treasure[] newtreasures = new Treasure[treasures.length-1];
        int i = 0;
        for(Treasure e: treasures){
            if(position.getRow() == e.getPosition().getRow()
                    && position.getCol() == e.getPosition().getCol()){
                continue;
            } else {
                newtreasures[i] = e;
                i++;
            }
        }
        treasures = newtreasures;

        if(treasures.length == 0){
            isActive = false;
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public int getRows() {
        return rows;
    }
    public int getColumns() {
        return columns;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

}
