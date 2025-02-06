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

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)",x,y);
    }

    public ChessboardPoint offset(int dx, int dy){
        if(this.x+dx<=7 && this.x+dx>=0 && this.y+dy<=7 && this.y+dy>=0){
            return new ChessboardPoint(x+dx,y+dy);
        }
        else {
            return null;
        }

    }

    @Override
    public boolean equals(Object o) {
        if(this==o)return true;
        if(o==null || getClass()!=o.getClass()) return false;
        ChessboardPoint point = (ChessboardPoint) o;
        return x==point.x && y==point.y;
    }
}
