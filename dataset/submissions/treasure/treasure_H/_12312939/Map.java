import java.util.Arrays;
public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.isActive = true;
    }
    public int hasTreasure(Position position) {
        if (isActive && position.getRow() >= 0 && position.getRow() < rows && position.getCol() >= 0 && position.getCol() < columns) {
            for (int i = 0; i < treasures.length; i++) {
                if (treasures[i].getPosition().getRow() == position.getRow() && treasures[i].getPosition().getCol() == position.getCol()) {
                    return treasures[i].getScore();
                }
            }
        }
            return 0;
    }
        public void update(Position position) {
            if (isActive && position.getRow() >= 0 && position.getRow() < rows && position.getCol() >= 0 && position.getCol() < columns) {
            boolean flag = false;
            for (int i = 0; i < treasures.length; i++) {
                if (treasures[i].getPosition().getRow() == position.getRow() && treasures[i].getPosition().getCol() == position.getCol()) {
                    treasures[i] = null;
                }
                if (treasures[i] != null) {
                    flag = true;
                }
            }
            if (!flag) {
                isActive = false;
            }
        }
    }
    public boolean isActive() {
       return isActive;
    }
}
