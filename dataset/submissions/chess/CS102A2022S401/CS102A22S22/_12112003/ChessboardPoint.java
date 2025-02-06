public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }
 @Override
    public boolean equals(Object obj) {
        if (this==obj){
            return true;
        }
        if (obj==null){
            return false;
        }
        if (getClass()!=obj.getClass())
            return false;
        ChessboardPoint other=(ChessboardPoint) obj;
        if (other.x==this.x&&other.y==this.y)
        {return true;}else return false;
    }
    @Override
    public String toString(){
        return String.format("(%d,%d)",x,y);
    }

    public ChessboardPoint offset(int dx, int dy){
        int fx=x+dx;
        int fy=y+dy;
        if (0<=fx&&0<=fy&&fx<=7&&fy<=7){
            return new ChessboardPoint(fx,fy);
        } else return null;
    }
}
