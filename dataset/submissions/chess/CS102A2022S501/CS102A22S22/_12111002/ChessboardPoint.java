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
        String point="(" + x + "," + y + ")";
        return point;
    }

    public ChessboardPoint offset(int dx, int dy) {
        int nx=x+dx,ny=y+dy;
        if (nx < 0 | 7 < nx | ny < 0 | 7 < ny) {
            return null;
        } else {
            ChessboardPoint chessboardPoint = new ChessboardPoint(nx, ny);
            return chessboardPoint;
        }
    }
    @Override
    public boolean equals(Object object){
        if (this==object){
            return true;
        }
        if (object==null||getClass()!=object.getClass()){
            return false;
        }
        ChessboardPoint Object=(ChessboardPoint) object;
        if (x!=Object.x){
            return false;
        }
        return y==Object.y;
    }
}
