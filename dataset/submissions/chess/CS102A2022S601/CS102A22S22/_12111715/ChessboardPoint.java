public class ChessboardPoint {
    private int x; // x: Horizontal location of this chess
    private int y; // y: Vertical location of this chess
    public ChessboardPoint(int x, int y){
        this.x=x;this.y=y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    @Override
    public String toString() {
        return String.format("(%s,%s)",x,y);
    }
    public ChessboardPoint offset(int dx, int dy){
        if (x+dx<=7&&y+dy<=7&&x+dx>=0&&y+dy>=0)return new ChessboardPoint(x+dx,y+dy);
        else return null;
    }
}