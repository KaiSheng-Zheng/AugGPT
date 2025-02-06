import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(char name) {
        super(name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        int x1, y1;
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        if (this.getChessColor().equals(ChessColor.BLACK)) {
            x1 = x + 1;
            y1 = y;
            if (x1 > -1 && x1 < 8 && y1 > -1 && y1 < 8) {
                if (chessComponents[x1][y1].getChessColor() == ChessColor.NONE) {
                    chessboardPoints.add(new ChessboardPoint(x1, y1));
                }
            }
            y1 = y - 1;
            if (x1 > -1 && x1 < 8 && y1 > -1 && y1 < 8) {
                if (chessComponents[x1][y1].getChessColor() == ChessColor.WHITE) {
                    chessboardPoints.add(new ChessboardPoint(x1, y1));
                }
            }
            y1 = y + 1;
            if (x1 > -1 && x1 < 8 && y1 > -1 && y1 < 8) {
                if (chessComponents[x1][y1].getChessColor() == ChessColor.WHITE) {
                    chessboardPoints.add(new ChessboardPoint(x1, y1));
                }
            }
            if (x == 1) {
                x1 = x + 2;
                y1 = y;
                if (chessComponents[x1 - 1][y1].getChessColor() == ChessColor.NONE
                        && chessComponents[x1][y1].getChessColor() == ChessColor.NONE) {
                    chessboardPoints.add(new ChessboardPoint(x1, y1));
                }
            }
        }
        if (this.getChessColor().equals(ChessColor.WHITE)) {
            x1 = x - 1;
            y1 = y;
            if (x1 > -1 && x1 < 8 && y1 > -1 && y1 < 8) {
                if (chessComponents[x1][y1].getChessColor() == ChessColor.NONE) {
                    chessboardPoints.add(new ChessboardPoint(x1, y1));
                }
            }
            y1 = y - 1;
            if (x1 > -1 && x1 < 8 && y1 > -1 && y1 < 8) {
                if (chessComponents[x1][y1].getChessColor() == ChessColor.BLACK) {
                    chessboardPoints.add(new ChessboardPoint(x1, y1));
                }
            }
            y1 = y + 1;
            if (x1 > -1 && x1 < 8 && y1 > -1 && y1 < 8) {
                if (chessComponents[x1][y1].getChessColor() == ChessColor.BLACK) {
                    chessboardPoints.add(new ChessboardPoint(x1, y1));
                }
            }
            if (x == 6) {
                x1 = x - 2;
                y1 = y;
                if (chessComponents[x1 + 1][y1].getChessColor() == ChessColor.NONE
                        && chessComponents[x1][y1].getChessColor() == ChessColor.NONE) {
                    chessboardPoints.add(new ChessboardPoint(x1, y1));
                }
            }
        }


        return chessboardPoints;
    }
}
