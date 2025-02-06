public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private boolean[] ju;

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public boolean isActive() {
        return isActive;
    }

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        ju=new boolean[treasures.length];
        for (int i=0;i<treasures.length;i++) {
            ju[i] = true;

        }
        isActive=true;
    }
    public int hasTreasure(Position position){
        for (int i=0;i<treasures.length;i++)
        {
            if (position.equals(treasures[i].getPosition())&&ju[i]) {
                return treasures[i].getScore();
            }
        }
        return 0;
    }
    public void update(Position position){
        int max=0;
        for (int i=0;i<treasures.length;i++)
        {
            if (position.equals(treasures[i].getPosition())&&ju[i]) {
                ju[i]=false;
            }
            if (ju[i]) max++;
        }
        if (max==0) isActive=false;
    }
}
