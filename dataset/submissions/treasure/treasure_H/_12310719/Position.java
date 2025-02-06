public class Position {
    private int row;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    private int col;

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Position(int row, int col){
        this.row=row;
        this.col=col;
    }
    public boolean equals(Object pos) {
        if (pos instanceof Position) {
            Position otherPos = (Position) pos;
            //System.out.println(1);
            //System.out.println(this.getCol());
            if (otherPos.getCol() == this.getCol() && otherPos.getRow() == this.getRow()) {
                //System.out.println(1);
                return true;
            }
            return false;
        }
        return false;
    }


}
