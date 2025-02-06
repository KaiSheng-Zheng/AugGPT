class Position {
    private int row;
    private int col;
    public Position(int ro, int co){
        row=ro;col=co;
    }
    public boolean equals(Object position){
        Position b=(Position)position;
        if(this.col==b.col&&this.row== b.row){
            return true;
        }
        return false;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return  col;
    }
    public void setRow(int ro){
        row=ro;
    }
    public void setCol(int co){
        col=co;
    }
}
