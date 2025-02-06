import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    private int x;
    private int y;
    private ChessComponent[][] chessboard;
    public RookChessComponent(int x, int y, ChessComponent[][] chessboard) {
        this.x = x;
        this.y = y;
        this.chessboard = chessboard;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result1 = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            if (offset1(x, y, 0, i) != null) {
                result1.add(offset1(x, y, 0, i));
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (offset1(x, y, 0, -i) != null) {
                result1.add(offset1(x, y, 0, -i));
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (offset1(x, y, i, 0) != null) {
                result1.add(offset1(x, y, i, 0));
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (offset1(x, y, -i, 0) != null) {
                result1.add(offset1(x, y, -i, 0));
            }
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
                if ((dx == 0) && (dy > 0)) {
                    for (int i = 1; i < dy; i++) {
                        if (chessboard[x][y + i].getChessColor() != ChessColor.NONE) {
                            return null;
                        }
                    }
                    return result;
                }
                if ((dx == 0) && (dy < 0)) {
                    for (int i = 1; i < -dy; i++) {
                        if (chessboard[x][y - i].getChessColor() != ChessColor.NONE) {
                            return null;
                        }
                    }
                    return result;
                }
                if ((dx > 0) && (dy == 0)) {
                    for (int i = 1; i < dx; i++) {
                        if (chessboard[x + i][y].getChessColor() != ChessColor.NONE) {
                            return null;
                        }
                    }
                    return result;
                }
                if ((dx < 0) && (dy == 0)) {
                    for (int i = 1; i < -dx; i++) {
                        if (chessboard[x - i][y].getChessColor() != ChessColor.NONE) {
                            return null;
                        }
                    }
                    return result;
                }
            }
            return null;
        }
    }
}
