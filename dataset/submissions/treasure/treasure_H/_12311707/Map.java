import java.util.*;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private TreeSet<Treasure>treasures=new TreeSet<>(new Comparator<Treasure>(){
        @Override
        public int compare(Treasure o1, Treasure o2) {
            if(o1.getScore()!=o2.getScore())return o1.getScore()-o2.getScore();
            if(o1.getPosition().getCol()!=o2.getPosition().getCol())return o1.getPosition().getCol()-o2.getPosition().getCol();
            return o1.getPosition().getRow()-o2.getPosition().getRow();
        }
    });
    public Map(int rows,int columns,Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        for(Treasure x:treasures)this.treasures.add(x);
        this.isActive=!this.treasures.isEmpty();
    }
    public int hasTreasure(Position position){
        for(Treasure x:treasures)
            if(x.getPosition().equals(position))return x.getScore();
        return 0;
    }
    public void update(Position position){
        if(treasures.isEmpty())return;
        for(Treasure x:treasures)
            if(x.getPosition().equals(position)){
                treasures.remove(x);
                if(treasures.isEmpty())this.isActive=false;
                return;
            }
    }
    public boolean isActive(){return isActive;}
    public int getRows(){return rows;}
    public int getColumns(){return columns;}
}