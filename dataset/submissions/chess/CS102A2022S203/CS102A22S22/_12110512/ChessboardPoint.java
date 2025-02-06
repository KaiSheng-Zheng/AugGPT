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
        return "(" + getX() + "," + getY() + ")";
    }

    public ChessboardPoint offset(int dx, int dy) {
        int newX = this.x + dx;
        int newY = this.y + dy;
        boolean OutOfRange = false;

        if (newX < 0 || newX > 7){
            OutOfRange = true;
        }
        else if (newY < 0 || newY > 7){
            OutOfRange = true;
        }

        if (OutOfRange)
            return null;
        else
            return new ChessboardPoint(newX, newY);
    }
}
