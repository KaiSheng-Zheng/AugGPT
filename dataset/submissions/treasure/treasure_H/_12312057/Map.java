import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private ArrayList<Treasure> treasures1;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures1 = new ArrayList<>(List.of(treasures));
        this.isActive = true;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int hasTreasure(Position position) {
        int sco = 0;
        for (Treasure t : treasures1) {
            if (t.getPosition().equals(position)) {
                sco = t.getScore();
            }
        }
        return sco;
    }

    public void update(Position position) {
//        Iterator<Treasure> iterator = treasures1.iterator();
//        while(iterator.hasNext()){
//            Treasure t = iterator.next();
//            if(t.getPosition().equals(position)){
//                iterator.remove();
//            }
//        }
        treasures1.removeIf(t -> t.getPosition().equals(position));
        if (treasures1.isEmpty()) {
            isActive = false;
        }
    }

    public boolean isActive() {
        return isActive;
    }
}
