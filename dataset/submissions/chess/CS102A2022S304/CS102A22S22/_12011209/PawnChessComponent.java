import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessColor color) {
        if (color.equals(ChessColor.WHITE)) super.name = 'p';
        if (color.equals(ChessColor.BLACK)) super.name = 'P';
        super.setChessColor(color);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        int x0 = super.getSource().getX();
        int y0 = super.getSource().getY();

        if (this.getChessColor().equals(ChessColor.WHITE)) {
            if (x0 == 6) {
                if (super.chessBoard[x0 - 1][y0].toString().equals("_") && super.chessBoard[x0 - 2][y0].toString().equals("_")) {
                    canMoveTo.add(new ChessboardPoint(x0 - 2, y0));
                }
            }
            if (x0 - 1 >= 0) {
                if (super.chessBoard[x0 - 1][y0].toString().equals("_")) {
                    canMoveTo.add(new ChessboardPoint(x0 - 1, y0));
                }

                if (y0 - 1 >= 0) {
                    if (!super.chessBoard[x0 - 1][y0 - 1].toString().equals("_") && chessBoard[x0 - 1][y0 - 1].getChessColor().equals(ChessColor.BLACK)) {
                        canMoveTo.add(new ChessboardPoint(x0 - 1, y0 - 1));
                    }
                }

                if (y0 + 1 <= 7) {
                    if (!super.chessBoard[x0 - 1][y0 + 1].toString().equals("_") && chessBoard[x0 - 1][y0 + 1].getChessColor().equals(ChessColor.BLACK)) {
                        canMoveTo.add(new ChessboardPoint(x0 - 1, y0 + 1));
                    }
                }
            }
        }

        if (this.getChessColor().equals(ChessColor.BLACK)) {
            if (x0 == 1) {
                if (super.chessBoard[x0 + 1][y0].toString().equals("_") && super.chessBoard[x0 + 2][y0].toString().equals("_")) {
                    canMoveTo.add(new ChessboardPoint(x0 + 2, y0));
                }
            }
            if (x0 + 1 <= 7) {
                if (super.chessBoard[x0 + 1][y0].toString().equals("_")) {
                    canMoveTo.add(new ChessboardPoint(x0 + 1, y0));
                }

                if (y0 - 1 >= 0) {
                    if (!super.chessBoard[x0 + 1][y0 - 1].toString().equals("_") && chessBoard[x0 + 1][y0 - 1].getChessColor().equals(ChessColor.WHITE)) {
                        canMoveTo.add(new ChessboardPoint(x0 + 1, y0 - 1));
                    }
                }

                if (y0 + 1 <= 7) {
                    if (!super.chessBoard[x0 + 1][y0 + 1].toString().equals("_") && chessBoard[x0 + 1][y0 + 1].getChessColor().equals(ChessColor.WHITE)) {
                        canMoveTo.add(new ChessboardPoint(x0 + 1, y0 + 1));
                    }
                }
            }
        }
        return canMoveTo;
    }
}
