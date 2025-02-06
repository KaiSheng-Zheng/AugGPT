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
        return "("+this.x+","+this.y+")";
    }

    public ChessboardPoint offset(int dx, int dy) {
        if((this.x+dx>=0&&this.x+dx<=7)&&(this.y+dy>=0&&this.y+dy<=7)){
            int a=x+dx;
            int b=y+dy;
            ChessboardPoint point=new ChessboardPoint(a,b);
            return point;
        }
        else
            return null;

    }
}
