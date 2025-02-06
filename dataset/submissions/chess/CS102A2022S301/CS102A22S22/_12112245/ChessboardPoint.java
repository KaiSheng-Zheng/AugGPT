public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y){
        this.x=x;
        this.y=y;


    }
    public int getX(){
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY(){
        return y;
    }

    @Override
    public String toString(){
        return "("+getX()+","+getY()+")";
    }
    public ChessboardPoint offset(int dx, int dy){
       int a=getX()+dx;
       int b=getY()+dy;
        if(a>7||a<0||b>7||b<0){
            return null;
        }else {
            return new ChessboardPoint(a,b);
        }
    }
}
