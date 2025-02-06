//package class_task_6_2;

public enum Direction {
    UP(-1,0),DOWN(1,0),LEFT(0,-1),RIGHT(0,1);
    private int col;
    private int row;
    Direction(int row,int col){
        this.row=row;
        this.col=col;
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
}
