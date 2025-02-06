public class ChessboardPoint {
    private int x;
    private int y;
    private int number;
    private final boolean cao;


    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
        cao= x <= 7 && x >= 0 && y <= 7 && y >= 0;
    }

    public boolean isCao() {
        return cao;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getNumber() {
        return 8*y+x;
    }

    @Override
    public String toString() {
        return "("+getX()+","+getY()+")";
    }


    public ChessboardPoint offset(int dx, int dy) {
      int  fx=x+dx;
      int fy=y+dy;
        ChessboardPoint jb=new ChessboardPoint(fx,fy);
        if( jb.isCao())return jb;
        else return null;
    }
}
