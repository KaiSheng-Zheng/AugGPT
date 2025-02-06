import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Map {
    private final int rows;
    private final int columns;
    private int count=0;
    private int count1=0;
    private int len=0;
    private int len1=0;
    private boolean isActive;
    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int hasTreasure(Position position){
            for (int i = 0; i < treasures.length; i++) {
                if(treasures[i]!=null){
                    if(position.equals(treasures[i].getPosition())){
                        return treasures[i].getScore();
                    }
                }
                else{
                    break;
                }
            }
            return 0;
        }
    public void update(Position position) {
        count++;
        if (count == 1) {
            List<Treasure> list = Arrays.asList(treasures);
            List arrayList = new ArrayList(list);
            len = list.size();
            for (int i = 0; i < len; i++) {
                if (position.equals(list.get(i).getPosition())) {
                    arrayList.remove(i);
                    len--;
                    arrayList.toArray(treasures);
                    break;
                }
            }
        } else {
            List<Treasure> list = Arrays.asList(treasures);
            List arrayList = new ArrayList(list);
            for (int i = 0; i < len; i++) {
                if (position.equals(list.get(i).getPosition())) {
                    arrayList.remove(i);
                    len--;
                    arrayList.toArray(treasures);
                    break;
                }
            }
        }
    }
        public boolean isActive () {
            if (!(treasures[0]==null)) {
                return true;
            }
            else{
                return false;
            }
        }
    }
