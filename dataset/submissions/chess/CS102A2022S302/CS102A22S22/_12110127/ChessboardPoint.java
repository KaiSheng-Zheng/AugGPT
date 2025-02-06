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
        return String.format("("+getX()+","+getY()+")");
    }


    public ChessboardPoint offset(int dx, int dy) {
        int nx=getX()+dx;int ny=getY()+dy;
        if ((nx<=7)&&(nx>=0)&&(ny<=7)&&(ny>=0)){
            ChessboardPoint chessboardPoint=new ChessboardPoint(nx,ny);
            return chessboardPoint;
        }else return null;
    }

    public ChessboardPoint offset(ChessboardPoint p) {
        int nx=this.getX()+p.getX();
        int ny=getY()+ p.getY();
        if ((nx<=7)&&(nx>=0)&&(ny<=7)&&(ny>=0)){
            ChessboardPoint chessboardPoint=new ChessboardPoint(nx,ny);
            return chessboardPoint;
        }else return null;
    }

    public boolean offset() {
        return (this.getX() > 7 || this.getY() > 7 || this.getX() < 0 || this.getY() < 0);
    }


    public static ChessboardPoint sum(ChessboardPoint a, ChessboardPoint b) {
        return new ChessboardPoint(a.getX()+b.getX(), a.getY()+b.getY());
    }

    public static ChessboardPoint product(ChessboardPoint p, int k) {
        return new ChessboardPoint(p.getX() * k, p.getY() * k);
    }
}