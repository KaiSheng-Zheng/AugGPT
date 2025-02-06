import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    private int x;
    private int y;
    private ChessComponent[][] chessboard;
    public KnightChessComponent(int x, int y, ChessComponent[][] chessboard) {
        this.x = x;
        this.y = y;
        this.chessboard = chessboard;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result1 = new ArrayList<>();
        if (offset1(x, y, -1, -2) != null) {
            result1.add(offset1(x, y, -1, -2));
        }
        if (offset1(x, y, 1, -2) != null) {
            result1.add(offset1(x, y, 1, -2));
        }
        if (offset1(x, y, -1, 2) != null) {
            result1.add(offset1(x, y, -1, 2));
        }
        if (offset1(x, y, 1, 2) != null) {
            result1.add(offset1(x, y, 1, 2));
        }
        if (offset1(x, y, -2, -1) != null) {
            result1.add(offset1(x, y, -2, -1));
        }
        if (offset1(x, y, 2, -1) != null) {
            result1.add(offset1(x, y, 2, -1));
        }
        if (offset1(x, y, -2, 1) != null) {
            result1.add(offset1(x, y, -2, 1));
        }
        if (offset1(x, y, 2, 1) != null) {
            result1.add(offset1(x, y, 2, 1));
        }
        LinkedHashSet<ChessboardPoint> hashSet = new LinkedHashSet<ChessboardPoint>(result1);
        ArrayList<ChessboardPoint> result2 = new ArrayList<>(hashSet);
        return result2;
    }


    public ChessboardPoint offset1(int x, int y, int dx, int dy) {
        int x1 = x + dx;
        int y1 = y + dy;
        ChessboardPoint result = new ChessboardPoint(x1, y1);
        if ((x1 < 0) || (x1 > 7)) {
            return null;
        }
        else if ((y1 < 0) || (y1 > 7)) {
            return null;
        }
        else {
            if (chessboard[x][y].getChessColor() != chessboard[x1][y1].getChessColor()) {
                return result;
            }
            else {
                return null;
            }
        }
    }
}
