public class ChessboardPoint {
    //Variables
    private int x;
    private int y;

    //Constructor
    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Setters and Getters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //Methods
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }

    public ChessboardPoint offset(int dx, int dy) {
        int newX = x + dx;
        int newY = y + dy;
        if ((newX >= 0) && (newX < 8) && (newY >= 0) && (newY < 8))
            return new ChessboardPoint(newX, newY);
        else
            return null;
    }
}
