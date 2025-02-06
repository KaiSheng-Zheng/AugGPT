public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y){
        this.x=x;
        this.y=y;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public String toString(){
        return "("+x+","+y+")";
    }
    public ChessboardPoint offset(int dx, int dy) {
        int a=this.x+dx;
        int b=this.y+dy;
        ChessboardPoint newChessboardPoint=new ChessboardPoint(a,b);
        if(a>=0 && a<8 && b>=0 && b<8)
            return newChessboardPoint;
        else
            return null;
    }
}
