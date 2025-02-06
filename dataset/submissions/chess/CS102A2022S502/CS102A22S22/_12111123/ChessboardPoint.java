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
       String a = "("+getX()+","+getY()+")";
        return a;
    }

    public ChessboardPoint offset(int dx, int dy) {
        int a = x + dx;
        int b = y + dy;
        ChessboardPoint R = new ChessboardPoint(a,b);
        int i = 0;
        if(a>=0&&a<=7){
            i++;
        }
        if(b>=0&&b<=7){
            i++;
        }
        if(i==2){
            return R;
        }else{
            return null;
        }
    }
}
