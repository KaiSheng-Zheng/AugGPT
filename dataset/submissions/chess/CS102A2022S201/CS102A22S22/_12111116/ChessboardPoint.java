public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }
    public String toString(){
        return "("+x+","+y+")";
    }
    public ChessboardPoint offset(int dx, int dy){
        int a=this.x+dx;
        int b=this.y+dy;
        if (a>=0&&a<=7&&b>=0&&b<=7){
            return new ChessboardPoint(a,b);
        }else {return null;}
    }
}
