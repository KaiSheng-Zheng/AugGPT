public class Position {
    private int row;
    private int col;
    public Position(int row, int col){
        this.row=row;this.col=col;
    }
    public boolean equals(Object position){
        if(position==null) return false;
        if(this==position) return true;
        if(!(position instanceof Position)) return false;
        Position poo=(Position) position;
        return (poo.col==this.col&&poo.row==this.row);
    }
    public int getRow(){
        return this.row;
    }
    public int getCol(){
        return this.col;
    }
    public void setRow(int x){
        this.row=x;
    }
    public void setCol(int x){
        this.col=x;
    }
}
