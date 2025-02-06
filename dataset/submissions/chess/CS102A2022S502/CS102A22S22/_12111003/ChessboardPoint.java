public class ChessboardPoint {
    private int x; // x: Horizontal location of this chess
    private int y; // y: Vertical location of this chess
    // example
    /*
    x\y 0 1 2 3 4 5 6 7
      0 R N B Q K B N R
      1 P P P P P P P P
      2 _ _ _ _ _ _ _ _
      3 _ _ _ _ _ _ _ _
      4 _ _ _ _ _ _ _ _
      5 _ _ _ _ _ _ _ _
      6 p p p p p p p p
      7 r n b q k b n r
    */
    public ChessboardPoint(int x, int y) {this.x = x; this.y = y;}
    public int getX() {return this.x;}
    public int getY() {return this.y;}
    @Override
    public String toString(){return "(" + this.x + "," + this.y + ")";}
    public ChessboardPoint offset(int dx, int dy){
        if (this.x + dx >= 0 && this.x + dx <= 7 && this.y + dy >= 0 && this.y + dy <= 7)
            return new  ChessboardPoint(this.x + dx, this.y + dy);
        else return null;
    }
}
