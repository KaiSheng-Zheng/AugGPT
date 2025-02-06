

import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {


    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        if (this.getChessColor() == ChessColor.WHITE) {
            if (x == 6) {
                if (chessComponents[x - 1][y].getChessColor() == ChessColor.NONE) {
                    canMoveTo.add(new ChessboardPoint(x - 1, y));
                }
                if (chessComponents[x - 2][y].getChessColor() == ChessColor.NONE) {
                    canMoveTo.add(new ChessboardPoint(x - 2, y));
                }
                if (y - 1 >= 0 && chessComponents[x - 1][y - 1].getChessColor() == ChessColor.BLACK) {
                    canMoveTo.add(new ChessboardPoint(x - 1, y - 1));
                }
                if (y + 1 < 8 && chessComponents[x - 1][y + 1].getChessColor() == ChessColor.BLACK) {
                    canMoveTo.add(new ChessboardPoint(x - 1, y + 1));
                }
            } else {
                if (x - 1 >= 0 && y - 1 >= 0 && chessComponents[x - 1][y - 1].getChessColor() == ChessColor.BLACK) {
                    canMoveTo.add(new ChessboardPoint(x - 1, y - 1));
                }
                if (x - 1 >= 0 && y + 1 < 8 && chessComponents[x - 1][y + 1].getChessColor() == ChessColor.BLACK) {
                    canMoveTo.add(new ChessboardPoint(x - 1, y + 1));
                }
                if (x - 1 >= 0 && chessComponents[x - 1][y].getChessColor() == ChessColor.NONE) {
                    canMoveTo.add(new ChessboardPoint(x - 1, y));
                }
            }
        } else {
            if (x == 1) {
                if (chessComponents[x + 1][y].getChessColor() == ChessColor.NONE) {
                    canMoveTo.add(new ChessboardPoint(x + 1, y));
                }
                if (chessComponents[x + 2][y].getChessColor() == ChessColor.NONE) {
                    canMoveTo.add(new ChessboardPoint(x + 2, y));
                }
                if (y + 1 < 8 && chessComponents[x + 1][y + 1].getChessColor() == ChessColor.WHITE) {
                    canMoveTo.add(new ChessboardPoint(x + 1, y + 1));
                }
                if (y - 1 >= 0 && chessComponents[x + 1][y - 1].getChessColor() == ChessColor.WHITE) {
                    canMoveTo.add(new ChessboardPoint(x + 1, y - 1));
                }
            } else {
                if (x + 1 < 8 && y + 1 < 8 && chessComponents[x + 1][y + 1].getChessColor() == ChessColor.WHITE) {
                    canMoveTo.add(new ChessboardPoint(x + 1, y + 1));
                }
                if (x + 1 < 8 && y - 1 >= 0 && chessComponents[x + 1][y - 1].getChessColor() == ChessColor.WHITE) {
                    canMoveTo.add(new ChessboardPoint(x + 1, y - 1));
                }
                if (x + 1 < 8 && chessComponents[x + 1][y].getChessColor() == ChessColor.NONE) {
                    canMoveTo.add(new ChessboardPoint(x + 1, y));
                }
            }
        }
        return canMoveTo;
    }

    public PawnChessComponent(ChessboardPoint point, ChessColor color, char name) {
        this.setSource(point);
        this.setChessColor(color);
        this.setName(name);
    }
}
