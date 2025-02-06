public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)",x,y);
    }
    public ChessboardPoint offset(int dx, int dy){
        if (this.x+dx>7||this.y+dy>7){
            return null;
        } else {
            return new ChessboardPoint(this.x+dx,this.y+dy);
        }
    }
}
