import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent() {
        super();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = getSource().getX();
        int y = getSource().getY();
        ChessComponent[][] chessboard = super.chessboard;
        List<ChessboardPoint> points = new ArrayList<>();
        ChessboardPoint po = new ChessboardPoint(x, y);
        for (int i = 1; i < 8; i++) {
            if ((x - i) >= 0 && (x - i) <= 7) {
                if (chessboard[x - i][y].getChessColor().equals(this.getChessColor())) {
                    break;
                } else if (chessboard[x - i][y].getChessColor().equals(ChessColor.NONE)) {
                    points.add(po.offset(-i, 0));
                } else {
                    points.add(po.offset(-i, 0));
                    break;
                }

            }
        }
        for (int i = 1; i < 8; i++) {
            if ((x + i) >= 0 && (x + i) <= 7) {
                if (chessboard[x + i][y].getChessColor().equals(this.getChessColor())) {
                    break;
                } else if (chessboard[x + i][y].getChessColor().equals(ChessColor.NONE)) {
                    points.add(po.offset(i, 0));
                } else {
                    points.add(po.offset(i, 0));
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if ((y + i) >= 0 && (y + i) <= 7) {
                if (chessboard[x][y + i].getChessColor().equals(this.getChessColor())) {

                    break;
                } else if (chessboard[x][y + i].getChessColor().equals(ChessColor.NONE)) {
                    points.add(po.offset(0, i));
                } else {
                    points.add(po.offset(0, i));
                    break;
                }
            }
        }

        for (int i = 1; i < 8; i++) {
            if ((y - i) >= 0 && (y - i) <= 7) {
                if (chessboard[x][y - i].getChessColor().equals(this.getChessColor())) {
                    break;
                } else if (chessboard[x][y - i].getChessColor().equals(ChessColor.NONE)) {
                    points.add(po.offset(0, -i));
                } else {
                    points.add(po.offset(0, -i));
                    break;
                }
            }
        }
        return points;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
