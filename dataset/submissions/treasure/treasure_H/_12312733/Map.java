public class Map {
    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.isActive = true;
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

    public void setActive(boolean active) {
        isActive = active;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public void setTreasures(Treasure[] treasures) {
        this.treasures = treasures;
    }

    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public int hasTreasure(Position position) {
        for (Treasure treasure : treasures) {
            if (position.equals(treasure.getPosition())) {
                return treasure.getScore();
            }
        }
        return 0;
    }

    public void update(Position position) {
        if (hasTreasure(position) != 0) {
            for (Treasure treasure : treasures) {
                if (treasure.getPosition().equals(position)) {
                    treasure.setScore(0);
                }
            }
        }
        int a = 1;
        for (Treasure treasure : treasures) {
            a *= (treasure.getScore() + 1);
        }
        if (a == 1) {
            isActive = false;
        } else {
            isActive = true;
        }
    }

}
