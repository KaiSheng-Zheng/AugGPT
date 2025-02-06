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

    public String toString() {
        String a = "(";
        String b = ",";
        String c = ")";
        String s = a.concat(String.valueOf(this.x)).concat(b).concat(String.valueOf(this.y)).concat(c);
        return s;
    }

    public ChessboardPoint offset(int dx, int dy) {
        int x = this.x + dx;
        int y = this.y + dy;
        ChessboardPoint q=new ChessboardPoint(x,y);
        if(x<0|x>7|y<0|y>7){
            return null;
        }else return q;
    }
}
