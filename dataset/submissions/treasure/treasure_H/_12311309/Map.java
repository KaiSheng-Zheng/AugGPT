import java.util.ArrayList;
public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private ArrayList<Treasure> treasures1;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.treasures1=new ArrayList<>();
        for(int i=0;i<treasures.length;i++){
            treasures1.add(treasures[i]);
        }
        isActive=true;
    }
    public int hasTreasure(Position position){
        for(int i=0;i<treasures1.size();i++){
            if(position.equals(treasures1.get(i).getPosition())){
                return treasures1.get(i).getScore();
            }
        }
        return 0;
    }
    public void update(Position position) {
        if (treasures1.isEmpty() )
            isActive=false;
        else{isActive=true;
            for (int i = 0; i < treasures1.size(); i++) {
                if (position.equals(treasures1.get(i).getPosition())) {
                    treasures1.remove(i);
                    }
                }
            if(treasures1.isEmpty())
                isActive=false;
            }
        }

    public boolean isActive(){
        return isActive;

    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
