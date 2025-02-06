public class ChessboardPoint implements Comparable<ChessboardPoint>{
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

    @Override
    public String toString() {
        return String.format("(%d,%d)",x,y);
    }

    public ChessboardPoint offset(int dx, int dy) {
        if (x+dx>=0 && x+dx<=7 && y+dy>=0 && y+dy <= 7){

            return new ChessboardPoint(x+dx,y+dy);
        }else return null;
    }

    @Override
    public boolean equals(Object o) {
        ChessboardPoint point = (ChessboardPoint) o;
        return point.getX() == x && point.getY() == y;
    }

    @Override
    public int compareTo(ChessboardPoint o) {
        if (this.x > o.x){
            return 1;
        }else if (this.x == o.x){
            if (this.y > o.y){
                return 1;
            }else {
                return -1;
            }
        }else  {
            return -1;
        }
    }
}
