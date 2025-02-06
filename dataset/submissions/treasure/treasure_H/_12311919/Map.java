public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private final Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
    }
    public int hasTreasure(Position position){
        int score=0;
        Position p=position;
        for (int i = 0; i <treasures.length ; i++) {
            if(treasures[i]==null)continue;
            if(p.getRow()==treasures[i].getPosition().getRow()&&p.getCol()==treasures[i].getPosition().getCol())
            {score+=treasures[i].getScore();
            }
        }
        return score;
    }
    public void update(Position position){
        Position p=position;
        for (int i = 0; i <treasures.length ; i++) {
            if(treasures[i]==null)continue;
            if(p.getRow()==treasures[i].getPosition().getRow()&&p.getCol()==treasures[i].getPosition().getCol())
            { treasures[i]=null;
            }
        }
    }

    public boolean isActive() {
        int a=0;
        for (Treasure treasure : treasures) {
            if (treasure == null)
                a++;
        }
        isActive=( a != treasures.length);
        return isActive;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
