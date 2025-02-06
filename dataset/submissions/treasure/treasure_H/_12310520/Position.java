public class Position {
    private int row;
    private int col;
    public boolean state;
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
        state=true;
    }
    public boolean equals(Object position){
        if(position instanceof Position){
            Position targetPosition=(Position) position;
            if(targetPosition ==null)return false;
            if(this.row== targetPosition.getRow()&&this.col==targetPosition.getCol())return true;
        }
        return false;
    }
    public void changeStatus(){
        state=false;
    }
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

    }
