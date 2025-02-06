public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.isActive = true;
    }

    public int hasTreasure(Position position) {
        for (Treasure treasure : treasures) {
            if (treasure.getPosition().equals(position)) {
                return treasure.getScore();
            }
        }
        return 0;
    }

    public void update(Position position) {
        
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getPosition().equals(position)) {
                treasures[i].setScore(0) ;
                break;
            }
        }
        isActive = false;
        for (Treasure treasure : treasures) {
            if (treasure.getScore() != 0) {
                isActive = true;
                break;
            }
        }
        
    }
    public boolean isActive() {
        if (isActive){
            return true;
        }else return false;
    }
    public int getRows() {
        return rows;
    }
    public int getColumns() {
        return columns;
    }




}

