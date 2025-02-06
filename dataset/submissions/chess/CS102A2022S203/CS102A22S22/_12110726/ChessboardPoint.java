public class ChessboardPoint {
    private int x; 
    private int y; 
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
    public boolean right(){
        return (x <= 7 && x >= 0 && y <= 7 && y >= 0);
    }

    public boolean equals(ChessboardPoint dian) {
        return dian.getX() == this.x && dian.getY() == this.y;
    }
}
