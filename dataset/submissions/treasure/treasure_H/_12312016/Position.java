public class Position {
    private int row;
    private int col;
    public Position(int row,int col){
        this.row=row;
        this.col=col;
        String p="("+row+","+col+")";
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public boolean equals(Object position){     // MIGHT BE WRONG!!
        Position p=(Position) position;
        if(position.equals(p)){
            return true;
        }else{
        return false;
    }}
}
