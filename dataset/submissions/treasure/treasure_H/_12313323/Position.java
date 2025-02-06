public class Position {
    public  int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    private int row;

    public int getCol() {
        return col;
    }


    public void setCol(int col) {
        this.col = col;
    }

    private int col;
    public Position(int row,int col){
        this.col=col;
        this.row=row;
    }
    public boolean equals(Object position){
        Position p=(Position) position;
        boolean panDuan = false;
        if(this.row==p.row&&this.col==p.col){
            panDuan=true;
        }
        else {
            panDuan=false;
        }
        return panDuan;
    }
}


