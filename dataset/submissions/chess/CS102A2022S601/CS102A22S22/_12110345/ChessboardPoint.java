public class ChessboardPoint {
    private int x;
    private int y;
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
        return "("+getX()+","+getY()+")";
    }
    public ChessboardPoint offset(int dx, int dy) {
        if(getX()+dx>=0&&getX()+dx<=7&&getY()+dy>=0&&getY()+dy<=7) {
            return new ChessboardPoint(getX() + dx, getY() + dy);
        }
        else{
            return null;
        }
    }
    @Override
    public boolean equals(Object o){
        if(o==null){
            return false;
        }
        if(o.getClass()!=this.getClass()){
            return false;
        }
        ChessboardPoint p=(ChessboardPoint) o;
        return x==p.x&&y==p.y;
    }
}
