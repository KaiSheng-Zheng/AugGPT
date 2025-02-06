public class ChessboardPoint {
    private int x;
    private int y;

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

    public String toString(){
        return "(" + String.valueOf(getX()) + "," +  String.valueOf(getY()) + ")";
    }

    public ChessboardPoint offset(int dx, int dy){
        int xx = x + dx;
        int yy = y + dy;
        if (xx<8 && xx>=0 && yy<8 && yy>=0){
            return new ChessboardPoint(xx,yy);
        }else{
            return null;
        }

    }
}
