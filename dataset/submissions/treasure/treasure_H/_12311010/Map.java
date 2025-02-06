import java.util.ArrayList;
import java.util.Arrays;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;




    public ArrayList<Treasure> treasureArrayList = new ArrayList<Treasure>();

    public boolean isActive() {
        if (treasureArrayList.isEmpty()){
            return false;
        } else {
            return true;
        }
    }

//    private ArrayList<Position> positionsNeededToUpdate = new ArrayList<Position>();

    public Map(int rows, int columns, Treasure[] treasures){
        this.rows = rows-1;
        this.columns = columns-1;
        treasureArrayList.addAll(Arrays.asList(treasures));
    }

    public int hasTreasure(Position position){
        Position h = (Position) position;
        int Ascore = 0;
        for (Treasure trea: treasureArrayList
             ) {
            if (trea.getPosition().equals(h)){
                Ascore = trea.getScore();
                break;
            } else {
                Ascore = 0;
            }
        }
        return Ascore;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
    public ArrayList<Treasure> TemTreasureArrayList = new ArrayList<Treasure>();
    public ArrayList<Treasure> TemTreasureArrayList_ = new ArrayList<Treasure>();
        public void update(Position position){
            treasureArrayList.removeIf(element -> element == null);
            TemTreasureArrayList.clear();
            TemTreasureArrayList.addAll(treasureArrayList);
            for (Treasure trea: treasureArrayList
                 ) {
                if (trea.getPosition() == position){
                    TemTreasureArrayList.remove(trea);
                }
            }
            treasureArrayList.clear();
            treasureArrayList.addAll(TemTreasureArrayList);
            TemTreasureArrayList.clear();
            }
        }



        
