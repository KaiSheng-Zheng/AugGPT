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

    public String toString(){
        return "(" + String.valueOf(x) + "," + String.valueOf(y) +")";
    }

    public ChessboardPoint offset(int dx, int dy){
        int new_x = dx + this.x, new_y = dy + this.y;
        if (0 <= new_x && new_x <= 7 && 0 <= new_y && new_y <= 7){
            return new ChessboardPoint(new_x, new_y);
        }
        return null;
    }
}
