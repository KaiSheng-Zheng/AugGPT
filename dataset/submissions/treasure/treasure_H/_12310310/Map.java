public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = (Math.max(rows, 0));
        this.columns = (Math.max(columns, 0));
        this.treasures = treasures;
        this.isActive = true;
    }

    public int hasTreasure(Position position) {
        int a = 0;
        int b = treasures.length;
        for (int i = 0; i < b; i++) {
            if (treasures[i].getPosition().getCol() == position.getCol() && treasures[i].getPosition().getRow() == position.getRow()) {
                a = treasures[i].getScore();
                break;
            }
        }
        return a;
    }

    public void update(Position position) {
        int j = 0;
        int b = treasures.length;
        Treasure[] temp = new Treasure[b - 1];
        for (Treasure in : treasures) {
            if (!(in.getPosition().getCol() == position.getCol() && in.getPosition().getRow() == position.getRow())) {
                temp[j] = in;
                j++;
            }
        }
        treasures = temp;
        if (treasures.length ==0){
            isActive =false;
        }
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
