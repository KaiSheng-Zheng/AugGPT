
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    private int x;
    private int y;
    private ChessComponent[][] chessboard;

    public PawnChessComponent(int x, int y, ChessComponent[][] chessboard) {
        this.x = x;
        this.y = y;
        this.chessboard = chessboard;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result1 = new ArrayList<>();
        if (chessboard[x][y].getChessColor() == ChessColor.BLACK) {
            if (offsetblack(x, y, 1, 0) != null) {
                result1.add(offsetblack(x, y, 1, 0));
            }
            if (offsetblack(x, y, 2, 0) != null) {
                result1.add(offsetblack(x, y, 2, 0));
            }
            if (offsetblack(x, y, 1, -1) != null) {
                result1.add(offsetblack(x, y, 1, -1));
            }
            if (offsetblack(x, y, 1, 1) != null) {
                result1.add(offsetblack(x, y, 1, 1));
            }
        }
        if (chessboard[x][y].getChessColor() == ChessColor.WHITE) {
            if (offsetblack(x, y, -1, 0) != null) {
                result1.add(offsetwhite(x, y, -1, 0));
            }
            if (offsetblack(x, y, -2, 0) != null) {
                result1.add(offsetwhite(x, y, -2, 0));
            }
            if (offsetblack(x, y, -1, -1) != null) {
                result1.add(offsetwhite(x, y, -1, -1));
            }
            if (offsetblack(x, y, -1, 1) != null) {
                result1.add(offsetwhite(x, y, -1, 1));
            }
        }
        LinkedHashSet<ChessboardPoint> hashSet = new LinkedHashSet<ChessboardPoint>(result1);
        ArrayList<ChessboardPoint> result2 = new ArrayList<>(hashSet);
        return result2;
    }


    public ChessboardPoint offsetblack(int x, int y, int dx, int dy) {
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
            if ((chessboard[x1][y1].getChessColor() != chessboard[x][y].getChessColor()) && (chessboard[x1][y1].getChessColor() != ChessColor.NONE) && (dy != 0)) {
             return result;
            }
            if ((dx == 1) && (dy == 0) && (chessboard[x1][y1].getChessColor() == ChessColor.NONE)) {
                return result;
            }
            if ((x == 1) && (dx == 2) && (dy == 0) && (chessboard[x + 1][y1].getChessColor() == ChessColor.NONE) && (chessboard[x1][y1].getChessColor() == ChessColor.NONE)) {
                return result;
            }
            return null;
        }
    }


    public ChessboardPoint offsetwhite(int x, int y, int dx, int dy) {
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
            if ((chessboard[x1][y1].getChessColor() != chessboard[x][y].getChessColor()) && (chessboard[x1][y1].getChessColor() != ChessColor.NONE) && (dy != 0)) {
                return result;
            }
            if ((dx == -1) && (dy == 0) && (chessboard[x1][y1].getChessColor() == ChessColor.NONE)) {
                return result;
            }
            if ((x == 6) && (dx == -2) && (dy == 0) && (chessboard[x - 1][y1].getChessColor() == ChessColor.NONE) && (chessboard[x1][y1].getChessColor() == ChessColor.NONE)) {
                return result;
            }
            return null;
        }
    }
}
