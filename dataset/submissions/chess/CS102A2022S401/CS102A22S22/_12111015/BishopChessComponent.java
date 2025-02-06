import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    private int x;
    private int y;
    private ChessComponent[][] chessboard;
    public BishopChessComponent(int x, int y, ChessComponent[][] chessboard) {
        this.x = x;
        this.y = y;
        this.chessboard = chessboard;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result1 = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            if (offset1(x, y, i, i) != null) {
                result1.add(offset1(x, y, i, i));
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (offset1(x, y, -i, i) != null) {
                result1.add(offset1(x, y, -i, i));
            }
        }
        for (int i = 0; i <= 7 ; i++) {
            if (offset1(x, y, i, -i) != null) {
                result1.add(offset1(x, y, i, -i));
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (offset1(x, y, -i, -i) != null) {
                result1.add(offset1(x, y, -i, -i));
            }
        }
        for (int i = 0; i < result1.size(); i++) {
            for (int j = 0; j < result1.size(); j++) {
                if(i != j && result1.get(i).equals(result1.get(j))) {
                    result1.remove(result1.get(j));
                }
            }
        }
        return result1;
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
                if ((dx > 0) && (dy > 0)) {
                    for (int i = 1; i < dx; i++) {
                        if (chessboard[x + i][y + i].getChessColor() != ChessColor.NONE) {
                            return null;
                        }
                    }
                    return result;
                }
                if ((dx < 0) && (dy > 0)) {
                    for (int i = 1; i < dy; i++) {
                        if (chessboard[x - i][y + i].getChessColor() != ChessColor.NONE) {
                            return null;
                        }
                    }
                    return result;
                }
                if ((dx > 0) && (dy < 0)) {
                    for (int i = 1; i < dx; i++) {
                        if (chessboard[x + i][y - i].getChessColor() != ChessColor.NONE) {
                            return null;
                        }
                    }
                    return result;
                }
                if ((dx < 0) && (dy < 0)) {
                    for (int i = 1; i < -dx; i++) {
                        if (chessboard[x - i][y - i].getChessColor() != ChessColor.NONE) {
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
