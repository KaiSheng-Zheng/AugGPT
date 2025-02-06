public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y){
        this.x=x;
        this.y=y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public String toString(){
        return ("("+getX()+","+getY()+")");
    }
    public ChessboardPoint offset(int dx, int dy){
        int x1=this.x+dx;
        int y1=this.y+dy;
        if(x1<0||x1>7||y1<0||y1>7){
            return null;
        } else{
            return new ChessboardPoint(x1,y1);
        }
    }
}
