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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    @Override
    public String toString() {
        return "("+getX()+","+getY()+")";
    }

    public ChessboardPoint offset(int dx, int dy) {
        int a=getX()+dx;
        int b=getY()+dy;
        if ((0<=a)&&(a<8)&&(0<=b)&&(b<8))
        {ChessboardPoint q=new ChessboardPoint(a,b);
            return q;
        } else
            return null;
    }

}
