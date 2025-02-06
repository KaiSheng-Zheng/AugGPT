import java.util.Objects;

public class ChessboardPoint {
    private int x; // x: Horizontal location of this chess
    private int y; // y: Vertical location of this chess

    public ChessboardPoint(){}
    public ChessboardPoint(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the coordinate of chessComponent in string format
     */
    @Override
    public String toString() {
        return String.format("(%d,%d)", this.getX(), this.getY());
    }

    /**
     * @return new coordinate of the chessComponent
     */
    public ChessboardPoint offset(int dx, int dy) {
        int x = this.getX() + dx;
        int y = this.getY() + dy;
        if (x >= 0 && x <= 7 && y >= 0 && y <= 7){
            return new ChessboardPoint(x, y);
        } else {
            return null;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getX(), this.getY());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        ChessboardPoint that = (ChessboardPoint) obj;
        return this.getX() == that.getX() && this.getY() == that.getY();
    }
}
