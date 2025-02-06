public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int X,int Y){
        this.x=X;
        this.y=Y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
    public String toString(){
        return String.format("(%d,%d)",x,y);
    }
    public ChessboardPoint offset(int dx,int dy){
        if (x+dx>7||x+dx<0){
            return null;
        }
        if (y+dy>7||y+dy<0){
            return null;
        }
        ChessboardPoint answer=new ChessboardPoint(x+dx,y+dy);
        return answer;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setXY(int x,int y){
        this.x=x;this.y=y;
    }

    public ChessboardPoint xinWei(int dx, int dy){
        ChessboardPoint ak=new ChessboardPoint(this.x,this.y);
        ak.x=this.x+dx;
        ak.y=this.y+dy;
        return ak;

    }

}
