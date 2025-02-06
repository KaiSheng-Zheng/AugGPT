public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public boolean equals(Object position){
        Position p = (Position) position;

        if(p.getCal()==this.col&&p.getRow()==this.row){
            return true;
        }else {
            return false;
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCal() {
        return col;
    }

    public void setCal(int col) {
        this.col = col;
    }
}
