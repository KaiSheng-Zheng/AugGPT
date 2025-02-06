class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
    }

    public int hasTreasure(Position position){
        for (int n=0;n<= treasures.length-1;n++){
            if(treasures[n].getPosition().equals(position)){
                return treasures[n].getScore();
            }
        }
        return 0;
    }

    public void update(Position position){
        for (int n=0;n<= treasures.length-1;n++){
            if(treasures[n].getPosition().equals(position)){
                    Position p00=new Position(-1,-1);
                    treasures[n]=new Treasure(0,p00);
            }
        }
    }

    public boolean isActive(){
        for (int n=0;n<=treasures.length-1;n++){
            if(treasures[n].getScore()!=0){
                return true;
            }
        }
        return false;
    }
}
