import java.util.ArrayList;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures ;
    private ArrayList<Boolean> judge  = new ArrayList<>();

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.isActive = true;
        for (int i=0;i<treasures.length;i++){
            judge.add(true);
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int hasTreasure(Position position) {
        for (int i=0;i<treasures.length;i++) {
            if (judge.get(i) && treasures[i].getPosition().equals(position)) {
                return treasures[i].getScore();
            }
        }
        return 0;
    }

    public void update(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (judge.get(i) && treasures[i].getPosition().equals(position)) {
                judge.remove(i);
                judge.add(i,false);// Remove the treasure from the map
                break;
            }
        }

        boolean allFound = true;
        for (int i = 0; i < treasures.length; i++) {
            if (judge.get(i)) {
                allFound = false;
                break;
            }
        }

        if (allFound) {
            isActive = false;
        }
    }



    public boolean isActive() {
        return isActive;
    }
}