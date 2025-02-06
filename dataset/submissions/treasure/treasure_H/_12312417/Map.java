import java.util.ArrayList;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive=true;
    private Treasure[] treasures;

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public void setTreasures(Treasure[] treasures) {
        this.treasures = treasures;
    }

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
    }
    public int hasTreasure(Position position){
        for (int i = 0; i < treasures.length; i++) {
            if(treasures[i].getPosition().equals(position)){
                int a=treasures[i].getScore();
                return a;
            }
        }
        return 0;
    }
    public void update(Position position){
        ArrayList<Treasure> list = new ArrayList<>();
        for (int j = 0; j < treasures.length; j++) {
            list.add(treasures[j]);
        }
        for (int i = 0; i < treasures.length; i++) {
            if(treasures[i].getPosition().equals(position)){
                list.remove(i);
                if (list.size()==0){
                   isActive=false;
                }
            }
        }
        Treasure[] treasures1=new Treasure[treasures.length-1];
        for (int i = 0; i <treasures1.length ; i++) {
            treasures1[i]=list.get(i);
        }
        this.treasures=treasures1;
    }
}
