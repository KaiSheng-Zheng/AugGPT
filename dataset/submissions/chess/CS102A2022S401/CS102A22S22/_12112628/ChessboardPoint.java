import java.util.ArrayList;
import java.util.List;

public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y) {
        if (!isPositionValid(x, y))
            throw new IllegalArgumentException("Invalid position!");

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
        int nx = x + dx;
        int ny = y + dy;
        if (!isPositionValid(nx, ny))
            return null;
        else
            return new ChessboardPoint(nx, ny);
    }

    public static boolean isPositionValid(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx <= 7 && ny <= 7;
    }

    public List<ChessboardPoint> getAround() {
        ArrayList<ChessboardPoint> ptList = new ArrayList<>();
        for (int i = -1; i <= 1; ++i)
            for (int j = -1; j <= 1; ++j) {
                if (i == 0 && j == 0)
                    continue;
                if (isPositionValid(x + i, y + j))
                    ptList.add(new ChessboardPoint(x + i, y + j));
            }
        return ptList;
    }

    public List<ChessboardPoint> getKnightPoints() {
        ArrayList<ChessboardPoint> ptList = new ArrayList<>();
        short[] distance = new short[]{-2, -1, 1, 2};
        ChessboardPoint pt;
        for (short dx : distance) {
            for (short dy : distance) {
                if (Math.abs(dx) != Math.abs(dy))
                    if ((pt = offset(dx, dy)) != null)
                        ptList.add(pt);
            }
        }
        return ptList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChessboardPoint that = (ChessboardPoint) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
