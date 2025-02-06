import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(char name) {
        super(name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        int x1 = x - 1;
        int y1 = y - 2;
        if (x1 > -1 && x1 < 8 && y1 > -1 && y1 < 8) {
            if (chessComponents[x1][y1].getChessColor() != this.getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x1, y1));
            }
        }
        x1 = x - 2;
        y1 = y - 1;
        if (x1 > -1 && x1 < 8 && y1 > -1 && y1 < 8) {
            if (chessComponents[x1][y1].getChessColor() != this.getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x1, y1));
            }
        }
        x1 = x - 1;
        y1 = y + 2;
        if (x1 > -1 && x1 < 8 && y1 > -1 && y1 < 8) {
            if (chessComponents[x1][y1].getChessColor() != this.getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x1, y1));
            }
        }
        x1 = x - 2;
        y1 = y + 1;
        if (x1 > -1 && x1 < 8 && y1 > -1 && y1 < 8) {
            if (chessComponents[x1][y1].getChessColor() != this.getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x1, y1));
            }
        }
        x1 = x + 1;
        y1 = y - 2;
        if (x1 > -1 && x1 < 8 && y1 > -1 && y1 < 8) {
            if (chessComponents[x1][y1].getChessColor() != this.getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x1, y1));
            }
        }
        x1 = x + 1;
        y1 = y + 2;
        if (x1 > -1 && x1 < 8 && y1 > -1 && y1 < 8) {
            if (chessComponents[x1][y1].getChessColor() != this.getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x1, y1));
            }
        }
        x1 = x + 2;
        y1 = y - 1;
        if (x1 > -1 && x1 < 8 && y1 > -1 && y1 < 8) {
            if (chessComponents[x1][y1].getChessColor() != this.getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x1, y1));
            }
        }
        x1 = x + 2;
        y1 = y + 1;
        if (x1 > -1 && x1 < 8 && y1 > -1 && y1 < 8) {
            if (chessComponents[x1][y1].getChessColor() != this.getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x1, y1));
            }
        }


        return chessboardPoints;
    }
}
