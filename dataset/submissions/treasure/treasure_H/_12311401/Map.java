import java.util.ArrayList;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private ArrayList<Treasure> nowTreasures=new ArrayList<>();
    private ArrayList<Integer> mark=new ArrayList<>();

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.isActive=true;
        for (int i = 0; i < treasures.length; i++) {
            this.nowTreasures.add(treasures[i]);
        }
        for (int i = 0; i < treasures.length; i++) {
            mark.add(0);
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public boolean isActive() {
        return isActive;
    }

    public int hasTreasure(Position position){
        int score=0;
        for (int i = 0; i < nowTreasures.size(); i++) {
            if (position.equals(nowTreasures.get(i).getPosition())){
                mark.set(i, 1);
                score=nowTreasures.get(i).getScore();
                break;
            }
        }
        return score;
    }
    public void update(Position position){
        for (int i = 0; i < nowTreasures.size(); i++) {
            if (position.equals(nowTreasures.get(i).getPosition())){
                if (mark.get(i) ==1){
                    nowTreasures.remove(i);
                    mark.remove(i);
                    break;
                }
            }
        }
        if(nowTreasures.isEmpty()){
            this.isActive=false;
        }
    }
}
