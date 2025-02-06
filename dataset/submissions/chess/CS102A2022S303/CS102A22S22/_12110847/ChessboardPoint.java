import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class ChessboardPoint implements Comparable<ChessboardPoint>{
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

    /**
     * should design
     * @return
     */
    public int getX() {
        return this.x;
    }

    /**
     * should design
     * @return
     */
    public int getY() {
        return this.y;
    }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return "(" + x + ","+ y +")";
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        if (dx + x < 0 || dx + x >= 8 || dy + y< 0 || dy + y >= 8) return null;
        return new ChessboardPoint(dx + x, dy + y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessboardPoint that = (ChessboardPoint) o;
        return x == that.x && y == that.y;
    }


    public static void main(String[] args) {
        ChessColor chessColor = ChessColor.BLACK;
        System.out.println(chessColor.name());
        ChessboardPoint chessboardPoint1 = new ChessboardPoint(1,3);
        ChessboardPoint chessboardPoint2 = new ChessboardPoint(2,1);
        ChessboardPoint chessboardPoint4 = new ChessboardPoint(2,1);
        ChessboardPoint chessboardPoint3 = new ChessboardPoint(1,-1);
        ArrayList<ChessboardPoint> list = new ArrayList<>();
        list.add(chessboardPoint1);
        list.add(chessboardPoint2);
        list.add(chessboardPoint3);
        list.add(chessboardPoint4);
        Collections.sort(list);
        for (ChessboardPoint c: list) {
            System.out.println(c);
        }
    }

    @Override
    public int compareTo(ChessboardPoint o) {
        if (x < o.x) return -1;
        else if (x == o.x) {
            if (y < o.y) return -1;
            else return 1;
        } else {
            return 1;
        }
    }

}
