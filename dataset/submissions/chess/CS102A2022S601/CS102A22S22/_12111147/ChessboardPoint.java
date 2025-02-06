public class ChessboardPoint {
    private int x; // x: Horizontal location of this chess
    private int y; // y: Vertical location of this chess
    public ChessboardPoint(int x, int y){
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
    public String toString(){
        return String.format("(%s,%s)",x,y);
    }

    public ChessboardPoint offset(int dx, int dy){
        if(this.x + dx <= 7 && this.x + dx >= 0 && this.y+dy<=7 && this.y >=0) {
            ChessboardPoint point = new ChessboardPoint(this.x + dx, this.y + dy);
            return point;
        }else
            return null;
    }

    public int setX(int x) {
        return x;
    }
    public int setY(int y){
        return y;
    }

}