public class ChessboardPoint {
    private int x, y;
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ChessboardPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "(" + getX() + "," + getY() + ")";
    }

    public ChessboardPoint offset(int dx, int dy){
        if(x + dx < 0 || x + dx >= 8 || y + dy < 0 || y + dy >= 8){
            return null;
        }else {
            return new ChessboardPoint( x+dx, y+dy);
        }
    }

}