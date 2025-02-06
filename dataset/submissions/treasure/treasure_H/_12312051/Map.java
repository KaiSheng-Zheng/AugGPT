import java.util.ArrayList;

public class Map {

    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;


    public Map(int rows, int columns, Treasure[] treasures){
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        n= treasures.length;
        for(int y=0;y<n;y++){
            ss.add(treasures[y].getScore());
        }

    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    ArrayList<Integer> ss=new ArrayList<>();

    int k=0;int s=0;int n;

    public int hasTreasure(Position position){
         for(k=0;k< treasures.length;k++){
            if(treasures[k].getPosition().equals(position)==true){
                return ss.get(k);
            }
         }
         return 0;
    }

    public void update(Position position){
        for(k=0;k<treasures.length;k++){
            if(treasures[k].getPosition().equals(position)==true){
                ss.set(k,0);
                break;
            }
        }
    }

    public boolean isActive(){
        int o=0;
        for(int y=0;y<n;y++){
            if(ss.get(y)!=0){
                o++;
            }
        }
        if(o==0){
            return false;
        }else{
            return true;
        }
    }
}
