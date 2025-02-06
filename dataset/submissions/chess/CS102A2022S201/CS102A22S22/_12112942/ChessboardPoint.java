public class ChessboardPoint {
    private int x; // x: Horizontal location of this chess
    private int y; // y: Vertical location of this chess

    public ChessboardPoint(int x, int y){
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
        StringBuilder position=new StringBuilder();
        position.append("(");
        position.append(x);
        position.append(",");
        position.append(y);
        position.append(")");
        return position.toString();
    }

    public ChessboardPoint offset(int dx, int dy){
        int qx=x+dx;
        int qy=y+dy;
        if(qx<0||qx>7){
            return null;
        }
        if(qy>7||qy<0){
            return null;
        }
        else{
            ChessboardPoint cp=new ChessboardPoint(qx,qy);
            return cp;
        }
    }
}
