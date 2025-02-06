public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }
@Override
    public String toString(){
        return "(" + x + "," +y + ")";
    }

    public ChessboardPoint offset(int dx, int dy){
        if (0 <= this.x + dx && this.x + dx <= 7 && 0 <= this.y + dy && this.y + dy <= 7 ){
            int x = this.x + dx;
            int y = this.y + dy;
            return new ChessboardPoint(x,y);
        }else {
            return null;
        }
    }
}
