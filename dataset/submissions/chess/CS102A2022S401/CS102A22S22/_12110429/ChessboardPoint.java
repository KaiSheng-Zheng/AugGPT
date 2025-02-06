import java.util.Objects;

public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x,int y){
if(x>=0&&x<=7&&y>=0&&y<=7){
    this.x=x;
    this.y=y;
}
    }
    public int getX(){return x;}
    public int getY(){
        return y;
    }
    public String toString(){
        return String.format("(%s,%S)",getX(),getY());
    }

    public boolean equals(ChessboardPoint chessboardPoint) {
    if (x==chessboardPoint.getX()&&y==chessboardPoint.getY()){
        return true;
    }else {
        return false;
    }
    }



    public ChessboardPoint offset(int dx, int dy){
        if(x+dx>=0&&x+dx<=7&&y+dy>=0&&y+dy<=7){
//            ChessboardPoint chessboardPoint=new ChessboardPoint(x+dx,y+dy);
            this.x=x+dx;
            this.y=y+dy;
            return this;
//            return chessboardPoint;
        }else return null;
    }

}
