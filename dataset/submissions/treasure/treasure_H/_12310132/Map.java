import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private ArrayList<Treasure> tt;
    private int score;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.tt=new ArrayList<>(Arrays.asList(treasures));


        }


    public int hasTreasure(Position position) {

            for (Treasure t : treasures) {
                if (t.getPosition() == position) {
                    score += t.getScore();
                }
            }
        return score;
    }

    public void update(Position position) {
        if (isActive()) {
            for (Treasure t : treasures) {
                if (t.getPosition() == position) {
                    tt.remove(t);
                }
            }
        }
        isActive();
    }

    public boolean isActive() {
        if (!tt.isEmpty()) {
            return true;
        } else{
            return false;
        }

    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
