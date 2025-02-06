import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = getSource().getX();
        int y = getSource().getY();
        List<ChessboardPoint> points = new ArrayList<>();
        ChessComponent[][] chessboard = super.chessboard;
        ChessboardPoint po = new ChessboardPoint(getSource().getX(), getSource().getY());

        for (int i = 1; i < 8; i++) {
            if ((x + i) >= 0 && (x + i) <= 7 && (y + i) >= 0 && (y + i) <= 7) {
                if (chessboard[x + i][y + i].getChessColor().equals(this.getChessColor())) {

                    break;
                } else if (chessboard[x + i][y + i].getChessColor().equals(ChessColor.NONE)) {
                    points.add(po.offset(i, i));
                } else {
                    points.add(po.offset(i, i));
                    break;
                }
            }
        }

        for (int i = 1; i < 8; i++) {
            if ((x + i) >= 0 && (x + i) <= 7 && (y - i) >= 0 && (y - i) <= 7) {


                if (chessboard[x + i][y - i].getChessColor().equals(this.getChessColor())) {

                    break;
                } else if (chessboard[x + i][y - i].getChessColor().equals(ChessColor.NONE)) {
                    points.add(po.offset(i, -i));
                } else {
                    points.add(po.offset(i, -i));
                    break;
                }
            }
        }

        for (int i = 1; i < 8; i++) {
            if ((x - i) >= 0 && (x - i) <= 7 && (y - i) >= 0 && (y - i) <= 7) {

                if (chessboard[x - i][y - i].getChessColor().equals(this.getChessColor())) {

                    break;
                } else if (chessboard[x - i][y - i].getChessColor().equals(ChessColor.NONE)) {
                    points.add(po.offset(-i, -i));
                } else {
                    points.add(po.offset(-i, -i));
                    break;
                }
            }
        }

        for (int i = 1; i < 8; i++) {
            if ((x - i) >= 0 && (x - i) <= 7 && (y + i) >= 0 && (y + i) <= 7) {

                if (chessboard[x - i][y + i].getChessColor().equals(this.getChessColor())) {

                    break;
                } else if (chessboard[x - i][y + i].getChessColor().equals(ChessColor.NONE)) {
                    points.add(po.offset(-i, i));
                } else {
                    points.add(po.offset(-i, i));
                    break;
                }
            }
        }
        return points;
    }
}
