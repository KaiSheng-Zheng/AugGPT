public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "("+this.x+","+this.y+")";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ChessboardPoint offset(int dx, int dy){
        int a = x + dx;
        int b = y + dy;
        if (x + dx > 7 || y + dy > 7 || x + dx < 0 || y + dy < 0){
            return null;
        }
        else return new ChessboardPoint(a, b);
    }
}