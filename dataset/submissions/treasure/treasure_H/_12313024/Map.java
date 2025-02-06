public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public Map (int rs, int cs, Treasure[] trs) {
        rows = rs - 1;
        columns = cs - 1;
        treasures = trs;
        isActive = true;
    }
    public boolean isActive () {
        return isActive;
    }
    public int getRows () {
        return rows;
    }
    public int getColumns () {
        return columns;
    }
    public int hasTreasure (Position pos) {
        for (int i = 0; i < treasures.length; i++)
            if (pos.getCol() == treasures[i].getPosition().getCol() && pos.getRow() == treasures[i].getPosition().getRow())
                return treasures[i].getScore();
        return 0;
    }
    public void update (Position pos) {
        for (int i = 0; i < treasures.length; i++)
            if (pos.getCol() == treasures[i].getPosition().getCol() && pos.getRow() == treasures[i].getPosition().getRow()) {
                treasures[i].getPosition().setRow(-1);
                treasures[i].getPosition().setCol(-1);
            }
        isActive = false;
        for (int i = 0; i < treasures.length; i++)
            if (treasures[i].getPosition().getCol() != -1 && treasures[i].getPosition().getRow() != -1)
                isActive = true;
    }
}
