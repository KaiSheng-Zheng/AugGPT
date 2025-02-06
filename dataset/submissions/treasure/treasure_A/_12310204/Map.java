

public class Map {

    private final int rows;
    private final int columns;
    private boolean isActive = true;
    private Treasure[] treasures;
    private int score = 0;
    public int[][] map;

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Map(int rows, int columns, Treasure[] treasures) {
        this.columns = columns;
        this.rows = rows;
        this.treasures = treasures;
        map = new int[rows][columns];
        for (int i = 0; i < treasures.length; i++) {
            map[treasures[i].getPosition().getRow()]
                    [treasures[i].getPosition().getCol()]
                    = treasures[i].getScore();
        }
    }

    public int hasTreasure(Position position) {
        score=map[position.getRow()][position.getCol()];
//        for (int i = 0; i < treasures.length; i++) {
//            if (position.equals(treasures[i].getPosition())) {
//                score = treasures[i].getScore();
//                break;
//            } else {
//                score = 0;
//            }
//        }
        return score;
    }

    public void update(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (position.equals(treasures[i].getPosition())) {
                map[treasures[i].getPosition().getRow()]
                        [treasures[i].getPosition().getCol()]
                        = 0;
                break;
            }
        }
    }

    public boolean isActive() {
        int count=0;

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == 0) {
                        count=count+1;
                    }
                }
            }
        if (count==rows*columns){
            isActive=false;
        }
        return isActive;
    }
}