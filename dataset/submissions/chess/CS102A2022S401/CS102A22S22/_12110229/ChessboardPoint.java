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

    public int getY(){
        return y;
    }

    public String toString(){
        return "(" + x + "," + y + ")";
    }

    public ChessboardPoint offset(int dx, int dy){
        int tmpX = x + dx;
        int tmpY = y + dy;
        if(tmpX<8 && tmpX>=0 && tmpY<8 && tmpY>=0){
            return new ChessboardPoint(tmpX, tmpY);
        }
        return null;
    }

}
