import java.util.Arrays;

public class ChessboardPoint {
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
        String ans = String.format("(%s,%s)",getX(),getY());
        return ans;
    }

    public ChessboardPoint offset(int dx, int dy) {
        int nx = this.x + dx;
        int ny = this.y + dy;
        if(nx >7||nx<0||ny>7||ny<0){
            return null;
        }else {
            ChessboardPoint ans = new ChessboardPoint(nx,ny);
            return ans;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChessboardPoint that = (ChessboardPoint) o;

        if (x != that.x) return false;
        return y == that.y;
    }
}
