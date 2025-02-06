public class Position {
    int row;
    int col;
    public Position(int row, int col, int score, Position pos){
        this.row=row;
        this.col=col;
        this.score = score;
        this.pos = pos;
    }
    public boolean equals(Object pos){
        Position otherPos = (Position) pos;
        if(this==pos) return true;
        else return false;
    }
    private final int score;
    private final Position pos;
}