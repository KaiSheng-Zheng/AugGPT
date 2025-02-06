public class ChessboardPoint {

    private int x; // x: Horizontal location of this chess
    private int y;
    public ChessboardPoint(int x, int y){
        if (x>=0&&x<=7&&y>=0&&y<=7){
            this.x=x;

        this.y=y;}
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
    public ChessboardPoint offset(int dx, int dy){
        ChessboardPoint newlocation = new ChessboardPoint(x+dx,y+dy);
        if ((x+dx)<=7&&(x+dx)>=0&&(y+dy)<=7&&(y+dy)>=0){
            return newlocation;
        }
        else return null;
    }
}
