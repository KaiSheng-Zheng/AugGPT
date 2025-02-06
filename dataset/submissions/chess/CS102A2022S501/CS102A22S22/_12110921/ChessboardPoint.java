public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    @Override
    public String toString(){
        return "("+x+","+y+")";
    }
    public ChessboardPoint offset(int dx,int dy){
        int nx=getX()+dx;
        int ny=getY()+dy;
        if (nx>=0&&nx<=7&&ny>=0&&ny<=7){
            return new ChessboardPoint(nx,ny);
        }
        else return null;
    }
}