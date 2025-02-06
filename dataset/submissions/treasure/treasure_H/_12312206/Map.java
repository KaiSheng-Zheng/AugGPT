
public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
    }

    public int hasTreasure(Position position) {
        int score = 0;
        for (int i = 0; i < treasures.length; i++) {
            if (position.equals(treasures[i].getPosition())) {
                score = treasures[i].getScore();
                break;
            }
        }
        return score;
    }

    public void update(Position position) {
        Treasure[] newlist = new Treasure[treasures.length - 1];
        for (int i = 0; i < treasures.length; i++) {
            if (position.equals(treasures[i].getPosition())) {
                for (int j = 0; j < i; j++) {
                    newlist[j] = treasures[j];
                }
                for (int x = i + 1; x < treasures.length; x++) {
                    newlist[x - 1] = treasures[x];
                }
                treasures = newlist;
                break;
            }
        }
    }

    public boolean isActive() {
        boolean flag = true;
        if (treasures.length == 0) {
            flag = false;
        }
        return flag;
    }
}