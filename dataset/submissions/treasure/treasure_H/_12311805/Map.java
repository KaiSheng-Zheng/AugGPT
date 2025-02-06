

import java.util.ArrayList;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive = true;
    private Treasure[] treasures;
    public int[][] arr;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        arr = new int[treasures.length][3];
        for (int i = 0; i < treasures.length; i++) {
            arr[i][0] = treasures[i].getScore();
            arr[i][1] = treasures[i].getPosition().getRow();
            arr[i][2] = treasures[i].getPosition().getCol();
        }
    }


    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }


    public boolean isActive() {
        if (isMapCleared()) {
            isActive = false;
        }
        return isActive;
    }

    public void update(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (arr[i][1] == position.getRow() && this.arr[i][2] == position.getCol()) {
                arr[i][0] = 0;
            }
        }
    }

    public int hasTreasure(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (position.getRow() == arr[i][1] && position.getCol() == arr[i][2]) {
                return arr[i][0];
            }
            if (isMapCleared()) {
                isActive = false;
            }
        }
        return 0;
    }

    private boolean isMapCleared() {
        int sum=0;
        for (int i = 0; i < treasures.length; i++) {
            sum+=arr[i][0];
        }
        return sum == 0;
    }
}
