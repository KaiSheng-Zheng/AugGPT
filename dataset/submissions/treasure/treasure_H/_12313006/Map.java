import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private List<Treasure> treasures;

    public Map(int rows, int columns, Treasure[] treasures){
        this.rows = rows;
        this.columns = columns;
        this.treasures = new LinkedList<>(Arrays.asList(treasures));
        isActive = true;
    }

    public int hasTreasure(Position position){
        return this.treasures.stream().filter(treasure -> treasure.getPosition().equals(position)).map(treasure -> treasure.getScore()).findAny().orElse(0);
    }

    public boolean isActive(){
        return isActive;
    }

    public void update(Position position){
        treasures.removeIf(treasure -> treasure.getPosition().equals(position));
        if(treasures.isEmpty()) isActive = false;
    }

    public boolean isInside(Position position){
        return position.getRow() >= 0 && position.getRow() < rows && position.getCol() >= 0 && position.getCol() < columns;
    }
}
