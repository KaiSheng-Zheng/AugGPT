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
        if(getX() + dx<=7&&getX() + dx>=0&&getY() + dy<=7&&getY() + dy>=0){
            return new ChessboardPoint(getX()+dx,getY()+dy);
        }
        else{
            return null;
        }
    }
}
