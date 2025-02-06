public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;

        this.treasures = new Treasure[treasures.length];
        for (int i=0;i<treasures.length;i++) {
            this.treasures[i] = new Treasure(treasures[i].getScore(),treasures[i].getPosition());
        }

        isActive=true;
        //this.treasures=treasures;
    }
    public int hasTreasure(Position position){
        int H=0;
        for (int i=0;i<treasures.length;i++){
            if ((!treasures[i].Found)&&(position.getRow()==treasures[i].getPosition().getRow()&&position.getCol()==treasures[i].getPosition().getCol())) {
                H = treasures[i].getScore();
            }
        }
            return H;
    }
    public void update(Position position){
        boolean clear=true;
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getPosition().equals(position) && !treasures[i].isFound()) {
                treasures[i].Found = true;
            }
        }
        for (int i=0;i<treasures.length;i++) {
            if(!treasures[i].Found)
                clear=false;
        }
        isActive =!clear;
    }
    public int updateTresure(Position position) {
        int score = 0;
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getPosition().equals(position) && !treasures[i].isFound()) {
                treasures[i].Found = true;
                score = treasures[i].getScore();
            }
        }
        update(new Position(-1,-1));

        return score;
    }


    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public boolean isActive() {
        return isActive;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }
}

