public class ChessboardPoint {
    private  int x;
    private  int y;

    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public ChessboardPoint() {

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
        int a = this.x;
        int b = this.y;
        int newX = a + dx;
        int newY = b + dy;
        if (0 <= newX && newX <=7 && 0 <= newY && newY <= 7) {
            return new ChessboardPoint(newX, newY);
        } else {
            return null;
        }
    }

}
