import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(int i, int j, ChessColor color, char k) {
        super(i, j, color, k);
    }

    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        List<ChessboardPoint> point = new ArrayList<>();
        if (x - 1 >= 0) {
            if (y - 1 >= 0) {
                if (chessboard[x - 1][y - 1].getChessColor() != this.getChessColor()) {
                    point.add(new ChessboardPoint(x - 1, y - 1));
                }
            }
            if (chessboard[x - 1][y].getChessColor() != this.getChessColor()) {
                point.add(new ChessboardPoint(x - 1, y));
            }
            if (y + 1 < 8) {
                if (chessboard[x - 1][y + 1].getChessColor() != this.getChessColor()) {
                    point.add(new ChessboardPoint(x - 1, y + 1));
                }
            }
        }
        if (y - 1 >= 0) {
            if (chessboard[x][y - 1].getChessColor() != this.getChessColor()) {
                point.add(new ChessboardPoint(x, y - 1));
            }
        }
        if (y + 1 < 8) {
            if (chessboard[x][y + 1].getChessColor() != this.getChessColor()) {
                point.add(new ChessboardPoint(x, y + 1));
            }
        }
        if (x + 1 < 8) {
            if (y - 1 >= 0) {
                if (chessboard[x + 1][y - 1].getChessColor() != this.getChessColor()) {
                    point.add(new ChessboardPoint(x + 1, y - 1));
                }
            }
            if (chessboard[x + 1][y].getChessColor() != this.getChessColor()) {
                point.add(new ChessboardPoint(x + 1, y));
            }
            if (y + 1 < 8) {
                if (chessboard[x + 1][y + 1].getChessColor() != this.getChessColor()) {
                    point.add(new ChessboardPoint(x + 1, y + 1));
                }
            }
        }
        return point;
    }
}