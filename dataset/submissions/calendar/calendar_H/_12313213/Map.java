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
    public int hasTreasure(Position position){
        for (Treasure i:treasures){
            if (i.getPosition().equals(position)){
                return i.getScore();
            }
        }
        return 0;
    }

    public void update(Position position){
        for (Treasure i:treasures){
            if (i.getPosition().equals(position)){
                i.setFind(false);
            }
        }
        for (Treasure i:treasures){
            if (i.isFind()==true){
                continue;
            }
            else {
                isActive = false;
            }
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
