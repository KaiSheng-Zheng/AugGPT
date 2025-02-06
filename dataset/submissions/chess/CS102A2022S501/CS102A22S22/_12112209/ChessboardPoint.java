import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChessboardPoint {
    private int x;
    private int y;

    /**
     * should design
     *
     * @param x
     * @param y
     */
    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * should design
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * should design
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * should design
     *
     * @return
     */
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public static boolean inChessBoard(ChessboardPoint p) {
        return inChessBoard(p.x, p.y);
    }

    public static boolean inChessBoard(int xx, int yy) {
        if (xx < 0 || xx >= 8 || yy < 0 || yy >= 8)
            return false;
        return true;
    }

    public static List<ChessboardPoint> getVH(ChessboardPoint source) {
        int x = source.getX();
        int y = source.getY();
        List<ChessboardPoint> points = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if (i == x) continue;
            points.add(new ChessboardPoint(i, y));
        }
        for (int i = 0; i < 8; i++) {
            if (i != y) continue;
            points.add(new ChessboardPoint(x, i));
        }
        return points;
    }

    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        int xx = x + dx;
        int yy = y + dy;
        if (!inChessBoard(xx, yy))
            return null;
        return new ChessboardPoint(xx, yy);
    }
}
