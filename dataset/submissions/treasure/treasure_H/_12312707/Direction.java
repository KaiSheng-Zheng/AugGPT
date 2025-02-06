public enum Direction {
    UP("UP"), DOWN("DOWN"), RIGHT("RIGHT"), LEFT("LEFT");
    //Add attributes
    private int row;
    private int col;
    private  String direction;
    //Add constructor:
    Direction(int row, int col) {
        this.row = row;
        this.col = col;
    }
    Direction(String direction) {
        this.direction = direction;
    }
    //Add methods
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public String toString() {
        return String.format("%s (%d, %d)",this.name(),this.row, this.col);
    }
}


