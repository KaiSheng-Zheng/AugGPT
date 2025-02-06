public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x,int y){
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
        return "(".concat(String.valueOf(getX())).concat(",").concat(String.valueOf(getY())).concat(")");
    }
    public ChessboardPoint offset(int dx, int dy){
        if(x+dx<8&&x+dx>-1&&y+dy<8&&y+dy>-1){
            return new ChessboardPoint(x+dx,y+dy);
        }
        else {
            return null;
        }
    }
}