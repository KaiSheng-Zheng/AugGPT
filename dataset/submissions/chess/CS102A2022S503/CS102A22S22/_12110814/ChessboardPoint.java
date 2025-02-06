
public class ChessboardPoint {

    private int x;
    private int y;

    /**
     * should design
     * @param x Horizontal location
     * @param y Vertical location
     */
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


    /**
     * @param dx delta X
     * @param dy delta Y
     * @return new ChessboardPoint of new Location
     */
    public ChessboardPoint offset(int dx, int dy) {
        int nx = this.x + dx;
        int ny = this.y + dy;
        if (nx >= 0 && nx <= 7 && ny >= 0 && ny <= 7)
            return new ChessboardPoint(nx, ny);
        else
            return null;
    }
}
