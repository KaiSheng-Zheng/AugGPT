class Position {
    private int row;
    private int col;
    private int havePlayer=0;

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

    public Position(int row, int col){
        this.row=row;
        this.col=col;
    }

    public boolean equals(Object position){
        Position p=(Position) position;
        if(this.row==p.getRow() && this.col== p.getCol()){
            return true;
        }
        else {
            return false;
        }
    }

    public int getHavePlayer() {
        return havePlayer;
    }

    public void setHavePlayer(int havePlayer) {
        this.havePlayer = havePlayer;
    }
}
