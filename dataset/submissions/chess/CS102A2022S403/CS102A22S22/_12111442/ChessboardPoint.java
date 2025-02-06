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

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public ChessboardPoint offset(int dx, int dy) {
        int nx = x + dx;
        int ny = y + dy;
        if (nx < 8 && nx >= 0 && ny < 8 && ny >= 0) {
            return new ChessboardPoint(nx,ny);
        }
        else return null;

    }


}
