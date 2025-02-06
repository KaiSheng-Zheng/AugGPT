import java.util.List;

public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y){
            this.x = x;
            this.y = y;
    }

    public int getX() {return x;}
    public int getY() {return y;}
    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y = y;}

    public String toString(){
    return  "("+String.valueOf(x)+","+String.valueOf(y)+")";
    }

    public ChessboardPoint offset(int dx, int dy){
        if(x+dx <= 7 && x+dx >= 0 && y+dy<= 7 && y+dy >= 0){
            return new ChessboardPoint(x+dx,y+dy);
        }else {
            return null;
        }
    }

    public boolean check(List<ChessboardPoint> chessboardPoints,int targetX,int targetY){
        if (chessboardPoints.size() != 0){
            for (ChessboardPoint a : chessboardPoints){
                if (a.getX() ==targetX && a.getY() ==targetY){
                    return true;
                }
            }
            return false;
        }else {
            return false;
        }
    }
}