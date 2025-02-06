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

    @Override
    public String toString() {
        return String.format("(%d,%d)",x,y);
    }

    public ChessboardPoint offset(int dx, int dy){
        ChessboardPoint op = new ChessboardPoint(x+dx,y+dy);
        if (dx+x > 7 || dy+y > 7 || dx+x < 0 || dy+y < 0){
            return null;
        }else{
            return op;
        }
    }

}
