public class Position {
    private int row;
    private int col;
    public Position(int row, int col){
        this.row=row;
        this.col=col;
    }
    public String toString(){return String.format("%d-%d",row,col);}
    public boolean equals(Object position){
        if(position instanceof Position)
            return this.toString().equals(position.toString());
        return false;
    }//
    public int getRow(){return row;}
    public int getCol(){return col;}
}