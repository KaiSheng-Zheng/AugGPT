
import java.util.Objects;

public class ChessboardPoint {
    private int x;
    private int y;

    /**
     * should design
     * @param x
     * @param y
     */
    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * should design
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * should design
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return "(" + x + ","+ y + ")";
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {

        int new_x = x + dx;
        int new_y = y + dy;
        if(!checkOut(new_x,new_y)) return null;
        return new ChessboardPoint(new_x,new_y);
    }


    public boolean checkOut(int nx,int ny){
        return nx >= 0 && nx <= 7 && ny >= 0  && ny <= 7 ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChessboardPoint)) return false;
        ChessboardPoint point = (ChessboardPoint) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
