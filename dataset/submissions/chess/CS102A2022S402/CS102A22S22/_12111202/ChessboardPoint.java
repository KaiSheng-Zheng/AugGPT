public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x,int y){
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

    @Override
    public String toString() {
        return "(" + x +
                "," + y +
                ")";
    }
    public ChessboardPoint offset(int dx,int dy){
        if ((dx+this.x<=7&&dx+this.x>=0)&&(dy+this.y<=7&&dy+this.y>=0)){
            ChessboardPoint a1=new ChessboardPoint(dx+this.x,dy+this.y);
            return a1;
        }
        else{
            return null;
        }
    }
}
