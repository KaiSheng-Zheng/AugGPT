public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.isActive = true;
    }
    public int hasTreasure(Position position){
        for (int i = 0; i < this.treasures.length; i++) {
            if (this.treasures[i].getPosition().equals(position)){
                return this.treasures[i].getScore();
            }
        }
        return 0;
    }
    public void update(Position position){
        if (this.treasures.length == 1){
            if (this.treasures[0].getPosition().equals(position)){
                Treasure[] temp = new Treasure[0];
                this.treasures = temp;
                this.isActive = false;
            }
        }else {
            for (int i = 0; i < this.treasures.length; i++) {
                if (this.treasures[i].getPosition().equals(position)){
                    Treasure[] temp = new Treasure[this.treasures.length - 1];
                    for (int j = 0; j < i; j++) {
                        temp[j] = this.treasures[j];
                    }
                    if (i != this.treasures.length - 1) {
                        for (int j = i; j < temp.length; j++) {
                            temp[j] = this.treasures[j + 1];
                        }
                    }
                    this.treasures = temp;
                }
            }
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