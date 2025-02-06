import java.util.Arrays;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private final Treasure[] treasures;

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
        for (Treasure treasure : treasures) {
            if (treasure.getPosition().equals(position)) {
                treasure.getPosition().setRow(-1); // marking found treasure's position as -1, -1
                treasure.getPosition().setCol(-1);
            }
        }
        checkActiveStatus();
    }

    public boolean isActive() {
        return isActive;
    }

    private void checkActiveStatus() {
        boolean allTreasuresFound = true;
        for (Treasure treasure : treasures) {
            if (treasure.getPosition().getRow() != -1 || treasure.getPosition().getCol() != -1) {
                allTreasuresFound = false;
                break;
            }
        }
        isActive = !allTreasuresFound;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}