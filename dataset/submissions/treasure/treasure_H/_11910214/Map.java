import java.util.*;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private  Treasure[] treasures;

    public Map(int rows, int columns,  Treasure[] treasures) {
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
        for (Treasure treasure : treasures) {
            if (treasure.getPosition().equals(position)) {
                treasure.getPosition().setRow(-1);
                treasure.getPosition().setCol(-1);
            }
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isValid(Position newPosition) {
        return newPosition.getRow() >= 0 && newPosition.getRow() < rows &&
                newPosition.getCol() >= 0 && newPosition.getCol() < columns;
    }
}