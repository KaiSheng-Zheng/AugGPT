public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x,int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString(){
        return "("+getX()+","+getY()+")";
    }
    public ChessboardPoint offset(int dx,int dy){
        int nx=getX()+dx;
        int ny=getY()+dy;
        if (nx<=7&&nx>=0&&ny<=7&&ny>=0){
            return new ChessboardPoint(nx,ny);
        }else return null;
    }
}
