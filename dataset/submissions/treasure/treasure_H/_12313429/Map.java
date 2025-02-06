import java.util.ArrayList;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private ArrayList<Treasure>treasureArrayList;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.isActive = treasures.length>0;
        treasureArrayList=new ArrayList<>();
        for (Treasure t:treasures
             ) {
            treasureArrayList.add(t);
        }
    }

    public int hasTreasure(Position position) {

           
            for (Treasure treasure : treasureArrayList) {
                if (treasure.getPosition().equals(position)) {
                    return treasure.getScore();
                }
            }
            return 0;
        }

    public void update(Position position) {
        
        Treasure foundTreasure = null;
        for (Treasure treasure : treasureArrayList) {
            if (treasure.getPosition().equals(position)) {
                foundTreasure = treasure;
                break;
            }
        }

        if (foundTreasure != null) {
            treasureArrayList.remove(foundTreasure);
            if (treasureArrayList.isEmpty()) {
                isActive = false;
            }
        }

    }

    public boolean isActive() {
        
        return isActive;
    }

    public int getRows() {

        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
