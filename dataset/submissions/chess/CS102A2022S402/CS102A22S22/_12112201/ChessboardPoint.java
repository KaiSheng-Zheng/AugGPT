public class ChessboardPoint {
    private int x, y;

    public ChessboardPoint(int x, int y) {
        this.x = x;
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
        return "(" + x + "," + y + ")";
    }
    @Override
    public boolean equals(Object o){
        if(o==null){
            return false;
        }
        if(o.getClass()!=this.getClass()){
            return false;
        }
        ChessboardPoint p=(ChessboardPoint)o;
        return x==p.x&&y==p.y;
    }


    public ChessboardPoint offset(int dx, int dy) {
        if ((getX()+dx<8&&getX()+dx>=0)&&(getY()+dy<8&&getY()+dy>=0)) {
            return new ChessboardPoint(getX() + dx,getY() + dy);
        } else {
            return null;
        }
    }
}
