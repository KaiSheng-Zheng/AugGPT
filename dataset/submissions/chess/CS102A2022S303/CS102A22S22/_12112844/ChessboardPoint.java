public class ChessboardPoint implements Comparable<ChessboardPoint> {
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
        return String.format("(%d,%d)", this.getX(), this.getY());
    }
    public ChessboardPoint offset(int dx, int dy) {
        if (((this.getX() + dx) <= 7) && ((this.getX() + dx) >= 0) && ((this.getY()) + dy <= 7) && ((this.getY()) + dy >= 0)) {
            ChessboardPoint newPoint = new ChessboardPoint(this.getX() + dx, this.getY() + dy);
            return newPoint;
        } else {
            return null;
        }
    }

    @Override
    public int compareTo(ChessboardPoint o) {
        if (getX() > o.getX()) {
            return 1;
        } else if (getX() < o.getX()) {
            return -1;
        } else if (getY() > o.getY()) {
            return 1;
        } else if (getY() < o.getY()) {
            return -1;
        } else {
            return 0;
        }
    }
    @Override
    public boolean equals(Object o){
        if(o==null){
            return false;
        }
        if(o.getClass()!=this.getClass()){
            return false;
        }
        ChessboardPoint p=(ChessboardPoint) o;
        return x==p.x&&y==p.y;
    }
}
