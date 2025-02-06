import java.util.ArrayList;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private ArrayList<Treasure> treasure=new ArrayList<>();

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        isActive=true;
        for (int i = 0; i <treasures.length; i++) {
            treasure.add(treasures[i]);

        }

    }
    public int hasTreasure(Position position){
        for (int i = 0; i < treasure.size(); i++) {
            if (treasure.get(i).getPosition().getRow()==position.getRow()&&treasure.get(i).getPosition().getCol()==position.getCol()){
                return treasure.get(i).getScore();
            }
        }
        return 0;
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

    public int  getTreasuresNum() {
        return treasure.size();
    }

    public void update(Position position){
        if (treasure.isEmpty()){
            isActive=false;
            return;
        }
        for (int i = 0; i < treasure.size(); i++) {
            if (treasure.get(i).getPosition().equals(position)){
                treasure.remove(i);
                if (treasure.isEmpty()){
                    isActive=false;
                    return;
                }
                break;
            }
        }



    }
}
