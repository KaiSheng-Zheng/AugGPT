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

    public int getY(){
        return y;
    }

    public void setX(int x){
        this.x=x;
    }
    public void setY(int Y){
        this.y=y;
    }

    @Override
    public String toString(){
        return String.format("(%d,%d)",x,y);
    }

    public ChessboardPoint offset(int dx,int dy){
        int fx,fy;
        fx=dx+x;
        fy=dy+y;
        if(fx<0||fx>7||fy<0||fy>7){return null;}
         else {ChessboardPoint point=new ChessboardPoint(fx,fy);return point;}
    }

}