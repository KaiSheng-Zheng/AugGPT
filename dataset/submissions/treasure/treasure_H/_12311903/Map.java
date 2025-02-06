import java.util.ArrayList;
import java.util.Arrays;

public class Map {
    private final int rows;
    private int b=0;
    private boolean isActive;

    private final int columns;
    private  Treasure[] treasures;
   private ArrayList<Treasure> treasurescopy=new ArrayList<>();


    public  Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
    }
    public int hasTreasure(Position position){
        treasurescopy.clear();
        for (int i=0;i<treasures.length;i++) {
            if (position.equals(treasures[i].getPos()) ) {
                b=i;copy();
                return treasures[i].getScore();
            }
        }
        return 0;
    }
    public boolean isActive(){
        int c=0;
        for (Treasure treasure : treasures) {
            if (treasure.getScore() == 0) {
                c++;
            }
        }
        return c != treasures.length;
    }
    public void update(Position position){
        treasures[b]= new Treasure(0,new Position(-1,-1));
    }
    public void copy(){
        treasurescopy.addAll(Arrays.asList(treasures));
    }

    public int getRow() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

}
