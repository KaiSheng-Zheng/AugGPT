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
        return String.format("(%d,%d)", x, y);
    }


    public ChessboardPoint offset(int dx, int dy) {
        int targetX = x + dx;
        int targetY = y + dy;
        if (targetX < 0 || targetX > 7 || targetY < 0 || targetY > 7) {
            return null;
        }
        return new ChessboardPoint(targetX, targetY);
    }
}