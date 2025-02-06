public class ChessboardPoint {
    private int x; // x: Horizontal location of this chess
    private int y;// y: Vertical location of this chess

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
        String output=String.format("(%d,%d)",this.x,this.y);
        return output;
    }

    public ChessboardPoint offset(int dx, int dy){
        int nowX=this.x+dx;
        int nowY=this.y+dy;
        if (nowX>7||nowX<1||nowY>7||nowY<1){
            return null;
        }
        ChessboardPoint now=new ChessboardPoint(nowX,nowY);
        return now;
    }

}