public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y=y;
    }


    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public String toString(){
        String s="("+getX()+","+getY()+")";
        return s;
    }

    public ChessboardPoint offset(int dx, int dy){
        if (x+dx<=7 && x+dx>=0 && y+dy<=7 && y+dy>=0){
           ChessboardPoint newPoint=new ChessboardPoint(x+dx,y+dy);
           return newPoint;
        }else{
            return null;
        }
    }

}
