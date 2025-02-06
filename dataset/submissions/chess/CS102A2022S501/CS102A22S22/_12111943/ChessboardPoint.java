public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {return x;}
    public int getY() {return y;}

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public ChessboardPoint offset (int dx, int dy){
        int X = x + dx;
        int Y = y + dy;
        if(X > 7 || X < 0 || Y > 7 || Y < 0){
            return null;
        }
        return new ChessboardPoint(X,Y);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        ChessboardPoint that = (ChessboardPoint) o;
        return x == that.x && y == that.y;
    }
}
