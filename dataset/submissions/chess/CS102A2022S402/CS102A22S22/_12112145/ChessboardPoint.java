public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "("+getX()+","+getY()+")";
    }


    public ChessboardPoint offset(int dx, int dy){
        ChessboardPoint offset = new ChessboardPoint(x,y);
        offset.x = getX()+dx;
        offset.y = getY()+dy;
        if (offset.x>7||offset.x<0||offset.y>7||offset.y<0)return null;
        else return offset;
    }
}