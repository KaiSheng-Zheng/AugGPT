import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    private boolean firststep = true;

    public boolean isFirststep() {
        return firststep;
    }

    public void setFirststep(boolean firststep) {
        this.firststep = firststep;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = getSource().getX();
        int y = getSource().getY();
        ChessComponent[][] chessboard = super.chessboard;
        List<ChessboardPoint> points = new ArrayList<>();
        ChessboardPoint po = new ChessboardPoint(x, y);
        if (getName() == 'P') {
            if (x == 1) {//first step
                if (chessboard[x + 1][y].getChessColor().equals(ChessColor.NONE)) {
                    points.add(po.offset(1, 0));
                    if (chessboard[x + 2][y].getChessColor().equals(ChessColor.NONE)) {
                        points.add(po.offset(2, 0));
                    }
                }
                if (y - 1 >= 0) {
                    if (chessboard[x + 1][y - 1].getChessColor().equals(ChessColor.WHITE)) {
                        points.add(po.offset(1, -1));
                    }
                }
                if (y + 1 <= 7) {
                    if (chessboard[x + 1][y + 1].getChessColor().equals(ChessColor.WHITE)) {
                        points.add(po.offset(1, 1));
                    }
                }
            } else {
                if (x + 1 <= 7) {
                    if (chessboard[x + 1][y].getChessColor().equals(ChessColor.NONE)) {
                        points.add(po.offset(1, 0));
                    }
                    if (y - 1 >= 0) {
                        if (chessboard[x + 1][y - 1].getChessColor().equals(ChessColor.WHITE)) {
                            points.add(po.offset(1, -1));
                        }
                    }
                    if (y + 1 <= 7) {
                        if (chessboard[x + 1][y + 1].getChessColor().equals(ChessColor.WHITE)) {
                            points.add(po.offset(1, 1));
                        }
                    }
                }
            }
        }

        if (getName() == 'p') {
            if (x == 6) {//first step
                if (chessboard[x - 1][y].getChessColor().equals(ChessColor.NONE)) {
                    points.add(po.offset(-1, 0));
                    if (chessboard[x - 2][y].getChessColor().equals(ChessColor.NONE)) {
                        points.add(po.offset(-2, 0));
                    }
                }
                if (y - 1 >= 0) {
                    if (chessboard[x - 1][y - 1].getChessColor().equals(ChessColor.BLACK)) {
                        points.add(po.offset(-1, -1));
                    }
                }
                if (y + 1 <= 7) {
                    if (chessboard[x - 1][y + 1].getChessColor().equals(ChessColor.BLACK)) {
                        points.add(po.offset(-1, 1));
                    }
                }
            } else {
                if (x - 1 >= 0) {
                    if (chessboard[x - 1][y].getChessColor().equals(ChessColor.NONE)) {
                        points.add(po.offset(-1, 0));
                    }
                    if (y - 1 >= 0) {
                        if (chessboard[x - 1][y - 1].getChessColor().equals(ChessColor.BLACK)) {
                            points.add(po.offset(-1, -1));
                        }
                    }
                    if (y + 1 <= 7) {
                        if (chessboard[x - 1][y + 1].getChessColor().equals(ChessColor.BLACK)) {
                            points.add(po.offset(-1, 1));
                        }
                    }
                }
            }
        }
        return points;
    }
}
