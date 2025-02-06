import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Map {

    private final int rows;
    private final int columns;

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    private boolean isActive;
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.isActive = true;
    }

    public int hasTreasure(Position pos){
        int score = 0;
        for (int i = 0; i < treasures.length; i++) {
            Treasure treasure = treasures[i];
            if (treasure.getPos().equals(pos)) {
                score = treasure.getScore();
            }
        }
        return score;
    }

    public void update(Position pos){
        List<Treasure> collect = Arrays.stream(treasures).filter(item -> {
            return !item.getPos().equals(pos);
        }).collect(Collectors.toList());
        treasures = collect.toArray(new Treasure[collect.size()]);
        if(treasures.length==0){
            isActive = false;
        }
    }

    public boolean isActive(){
        return isActive;
    }
}
