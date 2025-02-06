public class Position {
    private int row;
    private int col;
    public Position(int row, int col){
        this.col=col;
        this.row=row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public boolean equals(Object position) {
        if (this == position) return true;
        if (position == null || getClass() != position.getClass()) return false;
        Position positions = (Position) position;
        return row == positions.row && col == positions.col;
    }

   }
