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
        return "(" + (char)(x+'0') + "," + (char)(y+'0') + ")";
    }

    public ChessboardPoint offset(int dx, int dy) {
        int nx = x+dx, ny = y+dy;

        if(nx > 7 || nx < 0 || ny > 7 || ny < 0) return null;

        return new ChessboardPoint(nx,ny);
    }
}
