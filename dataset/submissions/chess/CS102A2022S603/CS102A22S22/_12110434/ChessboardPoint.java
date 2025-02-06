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


    @Override
    public String toString() {
            return "(" + x + "," + y + ")";
    }

    public ChessboardPoint offset(int dx, int dy) {
        ChessboardPoint m = new ChessboardPoint(x+dx,y+dy);
        if(m.getX()>=0&&m.getY()<8){
            return m;
        }
            return null;
        }
}
