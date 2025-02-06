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

    public String toString(){
        return "("+this.x+","+this.y+")";
    }

    public ChessboardPoint offset(int dx, int dy){
        int xx=0;
        int yy=0;

        if(this.x+dx<=7&&this.x+dx>=0&&this.y+dy<=7&&this.y+dy>=0){
            xx=getX()+dx;
            yy=getY()+dy;
            ChessboardPoint newPosition =new ChessboardPoint(xx,yy);
            return newPosition;
        }else return null;
}
}
