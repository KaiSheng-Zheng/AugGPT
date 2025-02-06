public class Map {
    private final int rows;
    private final int columns;

    private int treasureCounter;

    public boolean isActive() {
        return isActive;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    private boolean isActive;
    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.isActive = true;
        this.treasureCounter = 0;
    }
    public int hasTreasure(Position position){
        for (Treasure treasure : treasures) {
            if (position.equals(treasure.getPosition())) {
                return treasure.getScore();
            }
        }
        return 0;
    }

    public void update(Position position){
        for (int i = 0; i < treasures.length; i++) {
            if (position.equals(treasures[i].getPosition())) {
                treasures[i] = new Treasure(0,new Position(position.getRow(),position.getCol()));
                treasureCounter++;
                break;
            }
        }
        if(treasureCounter == treasures.length) {
            isActive = false;
        }
    }

}