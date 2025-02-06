

public class ChessboardPoint implements Comparable<ChessboardPoint> {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public String toString() {
        return "(" + x + ',' + y + ")";
    }

    public ChessboardPoint offset(int dx, int dy) {
        int xx, yy;
        xx = x + dx;
        yy = y + dy;
        if (xx >= 0 && xx <= 7) {
            if (yy >= 0 & yy <= 7) {
                return new ChessboardPoint(this.x, this.y);
            } else return null;
        } else return null;
    }


    @Override
    public int compareTo(ChessboardPoint o) {
        if (this.x > o.getX()) {
            return 1;
        } else if (this.x == o.getX()) {
            if (this.y > o.getY()) {
                return 1;
            } else return -1;
        } else return -1;
    }

    public boolean equal(ChessboardPoint a){
        if (this.getX()==a.getX()){
            if (this.getY()==a.getY()){
                return true;
            }else return false;
        }else return false;
    }
}
