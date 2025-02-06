public class ChessboardPoint {
    private int x; // x: Horizontal location of this chess
    private int y; // y: Vertical location of this chess

    public ChessboardPoint(int x, int y){
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

    public ChessboardPoint offset(int dx, int dy){
        int x1 = x + dx;
        int y1 = y + dy;
        if (x1 > 7 || x1 < 0 || y1 > 7 || y1 < 0)
            return null;
        return new ChessboardPoint(x1, y1);
    }

    public boolean legal(){
        return (x <= 7 && x >= 0 && y <= 7 && y >= 0);
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public boolean equals(ChessboardPoint obj) {
        return obj.getX() == this.x && obj.getY() == this.y;
    }
}
