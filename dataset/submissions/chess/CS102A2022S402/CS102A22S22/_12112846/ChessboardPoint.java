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
        return String.format("(%d,%d)",x,y);
    }


    public ChessboardPoint offset(int dx, int dy) {
        if (x+dx<=7 && x+dx>=0 && y+dy<=7 && y+dy>=0){
            return new ChessboardPoint(x+dx,y+dy);
        }
            return null;
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
}
