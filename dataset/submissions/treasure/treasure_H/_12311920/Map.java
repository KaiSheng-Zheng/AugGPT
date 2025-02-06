public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures){
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.isActive =true;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public boolean isActive() {
        return isActive;
    }

    public int hasTreasure(Position position){
        int score = 0;
        for (Treasure t : treasures){
            if (position.equals(t.getPosition())){
                score = t.getScore();
            }
        }
        return score;
    }
    public void update(Position position){
        isActive = false;
        for (int i = 0; i < treasures.length; i++){
            if (treasures[i].getPosition().equals(position)){
                treasures[i] = new Treasure(0 , new Position(-1 , -1));
            }
            if (treasures[i].getPosition().getRow() != -1 && treasures[i].getPosition().getCol() != -1){
                isActive = true;
            }

        }
    }
}
