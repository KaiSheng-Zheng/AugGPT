import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(char name) {
        super(name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        int x1, y1;
        for (int i = 1; i < 8; i++) {
            x1 = x + i;
            y1 = y;
            if (x1 > -1 && x1 < 8 && y1 > -1 && y1 < 8) {
                if (chessComponents[x1][y1].getChessColor() == ChessColor.NONE) {
                    chessboardPoints.add(new ChessboardPoint(x1, y1));
                    continue;
                }
                if (chessComponents[x1][y1].getChessColor() != this.getChessColor()) {
                    chessboardPoints.add(new ChessboardPoint(x1, y1));
                    break;
                }
                if (chessComponents[x1][y1].getChessColor() == this.getChessColor()) {
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            x1 = x - i;
            y1 = y;
            if (x1 > -1 && x1 < 8 && y1 > -1 && y1 < 8) {
                if (chessComponents[x1][y1].getChessColor() == ChessColor.NONE) {
                    chessboardPoints.add(new ChessboardPoint(x1, y1));
                    continue;
                }
                if (chessComponents[x1][y1].getChessColor() != this.getChessColor()) {
                    chessboardPoints.add(new ChessboardPoint(x1, y1));
                    break;
                }
                if (chessComponents[x1][y1].getChessColor() == this.getChessColor()) {
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            x1 = x;
            y1 = y + i;
            if (x1 > -1 && x1 < 8 && y1 > -1 && y1 < 8) {
                if (chessComponents[x1][y1].getChessColor() == ChessColor.NONE) {
                    chessboardPoints.add(new ChessboardPoint(x1, y1));
                    continue;
                }
                if (chessComponents[x1][y1].getChessColor() != this.getChessColor()) {
                    chessboardPoints.add(new ChessboardPoint(x1, y1));
                    break;
                }
                if (chessComponents[x1][y1].getChessColor() == this.getChessColor()) {
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            x1 = x;
            y1 = y - i;
            if (x1 > -1 && x1 < 8 && y1 > -1 && y1 < 8) {
                if (chessComponents[x1][y1].getChessColor() == ChessColor.NONE) {
                    chessboardPoints.add(new ChessboardPoint(x1, y1));
                    continue;
                }
                if (chessComponents[x1][y1].getChessColor() != this.getChessColor()) {
                    chessboardPoints.add(new ChessboardPoint(x1, y1));
                    break;
                }
                if (chessComponents[x1][y1].getChessColor() == this.getChessColor()) {
                    break;
                }
            }
        }



        return chessboardPoints;
    }
}
