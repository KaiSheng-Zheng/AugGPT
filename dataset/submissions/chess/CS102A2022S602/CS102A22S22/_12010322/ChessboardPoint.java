public class ChessboardPoint {
    private int x=0;
    private int y=0;
    public ChessboardPoint(int x, int y){ this.x=x;this.y=y; }

    public int getX() { return x; }

    public int getY() { return y; }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }

    public ChessboardPoint offset(int dx, int dy){
        int x2=this.x+dx;
        int y2=this.y+dy;
        if(x2>=0&&x2<8&&y2>=0&&y2<8){
        ChessboardPoint a=new ChessboardPoint(x2,y2);
        return a;}
        else { return null; }
    }

}
