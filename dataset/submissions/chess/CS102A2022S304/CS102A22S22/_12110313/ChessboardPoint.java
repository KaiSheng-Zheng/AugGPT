public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }


    @Override
    public String toString() {
        return "("+this.x+","+this.y+")";
    }

    public ChessboardPoint offset(int dx, int dy) {
        ChessboardPoint moved = new ChessboardPoint(this.x + dx,this.y + dy);
        if (this.x + dx <= 7 && this.x + dx >= 0 && this.y + dy <=7 && this.y + dy >=0){
            return moved;
        }else {
            return null;
        }
    }

}
