public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
    }

    public int hasTreasure(Position position){
        int score = 0;
        for (int i = 0 ; i < treasures.length ; i++){
            if (treasures[i].getPosition().equals(position))
                if (!treasures[i].isOut())
                    score = treasures[i].getScore();
        }
        return score;
    }

    public void update(Position position){
        for (int i = 0 ; i < treasures.length ; i++){
            if (treasures[i].getPosition().equals(position))
                treasures[i].setOut(true);
        }
    }

    public boolean isActive(){
        boolean isActive = false;
        for (int i = 0 ; i < treasures.length ; i++){
            if (!treasures[i].isOut())
                isActive = true;
        }
        return isActive;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
