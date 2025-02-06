import java.util.ArrayList;
import java.util.List;

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
        return "(" + x + "," + y + ')';
    }

    public ChessboardPoint offset(int dx, int dy) {
        dx = x + dx;
        dy = y + dy;
        if (dx >= 0 && dx <= 7 && dy >= 0 && dy <= 7)
            return new ChessboardPoint(dx, dy);
        return null;
    }

    public static boolean inChess(int x, int y) {
        return x >= 0 && x <= 7 && y >= 0 && y <= 7;
    }


    public static List<ChessboardPoint> getXXYY(int sx, int sy) {
        List<ChessboardPoint> list = new ArrayList<>();
        for (int x = 0; x < 8; x++) {
            if (x == sx) continue;
            list.add(new ChessboardPoint(x, sy));
        }
        for (int y = 0; y < 8; y++) {
            if (y == sy) continue;
            list.add(new ChessboardPoint(sx, y));
        }

        return list;
    }

    public static List<ChessboardPoint> getXYYX(int sx, int sy) {
        List<ChessboardPoint> list = new ArrayList<>();
        int x, y;

        x = sx;
        y = sy;
        while (x >= 0 && y >= 0) {
            x--;
            y--;
            list.add(new ChessboardPoint(x, y));
        }

        x = sx;
        y = sy;
        while (x < 8 && y < 8) {
            x++;
            y++;
            list.add(new ChessboardPoint(x, y));
        }

        x = sx;
        y = sy;
        while (x >= 0 && y < 8) {
            x--;
            y++;
            list.add(new ChessboardPoint(x, y));
        }

        x = sx;
        y = sy;
        while (x < 8 && y > 0) {
            x++;
            y--;
            list.add(new ChessboardPoint(x, y));
        }
        return list;
    }


}
