public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x,int y){
        this.x=x;
        this.y=y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public String toString(){
        return "("+x+","+y+")";
    }
    public ChessboardPoint offset(int dx,int dy){
        int a=x+dx;
        int b=y+dy;
        if(a>7||b>7||a<0||b<0){
            return null;
        }
        else{
            return new ChessboardPoint(a,b);
        }
    }
}
