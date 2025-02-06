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

    public String toString(){
        return String.format("(%d,%d)",getX(),getY());
    }

    public ChessboardPoint offset(int dx, int dy){
        ChessboardPoint point = new ChessboardPoint(getX()+dx,getY()+dy);
        if(point.getX() >= 0 && point.getX() <= 7 && point.getY() >= 0 && point.getY() <= 7){
            return point;
        }else {
            return null;
        }
    }
}
