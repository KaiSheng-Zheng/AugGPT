public class ChessboardPoint implements Comparable<ChessboardPoint>{
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
        return "(" + x + "," + y + ")";
    }
    public ChessboardPoint offset(int dx, int dy){
        dx += x;
        dy += y;
        if (dx <= 0 || dy <= 0 || dx > 8 || dy > 8){ // should be > 7, since the board is ranging from 0 to 7.
            return null;
        }
        return new ChessboardPoint(dx, dy);
    }

    @Override
    public int compareTo(ChessboardPoint o) {
        if (x == o.x){
            return y - o.y;
        }
        return x - o.x;
    }
}
