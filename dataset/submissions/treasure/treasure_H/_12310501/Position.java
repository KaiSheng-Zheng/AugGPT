public class Position {
    private int row;
    private int col;

    public Position(int row, int col){
        this.row = row;
        this.col = col;
    }

    public boolean equals(Object position){
        Position p = (Position)position;
        return (p.row == this.row && p.col == this.col);
    }

    public int getRow(){ return this.row; }
    public int getCol(){ return this.col; }
    public void setRow(int row){ this.row = row; }
    public void setCol(int col){ this.col = col; }

    public String toString(){
        return String.format("%d,%d", this.row, this.col);
    }
}
