public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y){
        this.x=x;
        this.y=y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
   @Override
    public String toString(){
        return "("+x+","+y+")";
   }
   public ChessboardPoint offset(int dx, int dy){
        if (dx+x>7||dx+x<0||dy+y>7||dy+y<0)
            return null;
        else {
            return new ChessboardPoint(x+dx,y+dy);
        }
   }

}
