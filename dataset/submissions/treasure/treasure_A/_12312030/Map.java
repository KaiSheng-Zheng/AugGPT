import java.util.ArrayList;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private ArrayList<Treasure> treasures;
    private boolean isactive;
    public boolean getIsactive(){return isactive;}
    public Map(int rows, int columns, Treasure[] treasures) {
        this.treasures=new ArrayList<Treasure>();
        this.rows=rows;
        this.columns=columns;
        isActive=true;
        int L=treasures.length;
        for(int i=0;i<L;i++) {
            this.treasures.add(treasures[i]);
        }
        isactive=true;
    }
    public int getRows() {return rows;}
    public int getColumns() {return columns;}
    public int hasTreasure(Position position){
        for(int i=0;i<treasures.size();i++)
            if(position.equals(treasures.get(i).getPosition())) return treasures.get(i).getScore();
        return 0;
    }
    public int get_id(Position position) {
        for(int i=0;i<treasures.size();i++)
            if(position.equals(treasures.get(i).getPosition())) return i;
        return -1;
    }
    public boolean isActive() {return isactive;}
    public void update(Position position){
        if(!isactive) return;
        int id=get_id(position);
        if(id==-1) return ;
        treasures.remove(id);
        if(treasures.size()==0) isactive=false;
        return;
    }

}
