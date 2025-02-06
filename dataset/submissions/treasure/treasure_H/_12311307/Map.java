public class Map {
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    private final int rows;
    private final int columns;

    public boolean isActive() {
        return isActive;
    }

    private boolean isActive=true;
    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
    }
        public int hasTreasure(Position position){
            int score=0;
            for (Treasure t:treasures) {
                if (position.equals(t.getPosition())){
                    score=t.getScore();
                     break;
                }
            }
            return score;
        }
    public void update(Position position){
        int a=0;
        if (treasures.length==1)isActive=false;
        else for (int i = 0; i < treasures.length; i++) {
            if (position.equals(treasures[i].getPosition())) {a=i;}}
        Treasure[]New=new Treasure[treasures.length-1];
        for (int j = 0; j < a; j++) {
            New[j]=treasures[j];
        }
        if (a!=treasures.length-1)
            for (int j = a+1; j < treasures.length; j++) {
                New[j-1]=treasures[j];
            }
        treasures=New;

    }

    }
