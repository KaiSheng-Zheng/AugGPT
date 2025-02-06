public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.isActive=true;
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
        for (Treasure t :treasures){
            if (position.equals(t.getPosition())&&t.canGet){
                return t.getScore();
            }
        }
        return 0;
    }
    public void update(Position position){
        for (Treasure t:treasures){
           if (position.equals(t.getPosition())){
               t.canGet = false;
           }
        }
        for (Treasure t:treasures){
            if (t.canGet){
                this.isActive = true;
                break;
            }else {
                this.isActive = false;
            }
        }
    }
}