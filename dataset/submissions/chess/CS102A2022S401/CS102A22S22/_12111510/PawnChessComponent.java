import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
        name = chessColor == ChessColor.WHITE ? 'p' : 'P';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> moveTo = new ArrayList<>();
        int x = source.getX();
        int y = source.getY();

        if (chessColor == ChessColor.BLACK && x == 1) {
            for (int i = 0; i < 8; i++) {
                if (chessBoard[i][2].chessColor != ChessColor.BLACK) moveTo.add(new ChessboardPoint(i, 2));
                else if (chessBoard[i][3].chessColor != ChessColor.BLACK && chessBoard[i][2].chessColor == ChessColor.NONE)
                    moveTo.add(new ChessboardPoint(i, 3));
                else if (getChessColor(chessBoard[i + 1][y + 1].name) == ChessColor.WHITE &&  i + 1 < 8 ) {
                    moveTo.add(new ChessboardPoint(i + 1, y + 1));
                } else if (getChessColor(chessBoard[i - 1][y + 1].name) == ChessColor.WHITE ) {
                    moveTo.add(new ChessboardPoint(i - 1, y + 1));
                }
            }
        } else if (chessColor == ChessColor.BLACK) {
            if (getChessColor(chessBoard[x + 1][y + 1].name) == ChessColor.WHITE && x + 1 >= 0 && x + 1 < 8 && y + 1 >= 0 && y + 1 < 8) {
                moveTo.add(new ChessboardPoint(x + 1, y + 1));
            } else if (getChessColor(chessBoard[x - 1][y + 1].name) == ChessColor.WHITE && x - 1 >= 0 && x - 1 < 8 && y + 1 >= 0 && y - 1 < 8) {
                moveTo.add(new ChessboardPoint(x - 1, y + 1));
            } else if (getChessColor(chessBoard[x][y + 1].name) == ChessColor.WHITE && x - 1 >= 0 && x - 1 < 8 && y + 1 >= 0 && y - 1 < 8) {
                moveTo.add(new ChessboardPoint(x, y + 1));
            }
        }
        if (chessColor == ChessColor.WHITE && y == 6) {
            for (int i = 0; i < 8; i++) {
                if (chessBoard[i][4].chessColor != ChessColor.WHITE) moveTo.add(new ChessboardPoint(i, 4));
                else if (chessBoard[i][5].chessColor != ChessColor.WHITE && chessBoard[i][4].chessColor == ChessColor.NONE)
                    moveTo.add(new ChessboardPoint(i, 5));
                else if (getChessColor(chessBoard[i + 1][y - 1].name) == ChessColor.BLACK && i + 1 >= 0 && x + 1 < 8 ) {
                    moveTo.add(new ChessboardPoint(i + 1, y - 1));
                } else if (getChessColor(chessBoard[i - 1][y - 1].name) == ChessColor.BLACK &&  i - 1 < 8 ) {
                    moveTo.add(new ChessboardPoint(i - 1, y - 1));
                }
            }
        } else if (chessColor == ChessColor.WHITE) {
            if (getChessColor(chessBoard[x + 1][y - 1].name) == ChessColor.BLACK && x + 1 >= 0 && x + 1 < 8 && y - 1 >= 0 && y - 1 < 8) {
                moveTo.add(new ChessboardPoint(x + 1, y - 1));
            } else if (getChessColor(chessBoard[x - 1][y - 1].name) == ChessColor.BLACK && x - 1 >= 0 && x - 1 < 8 && y - 1 >= 0 && y - 1 < 8) {
                moveTo.add(new ChessboardPoint(x - 1, y - 1));
            } else if (getChessColor(chessBoard[x - 1][y - 1].name) == ChessColor.BLACK && x - 1 >= 0 && x - 1 < 8 && y - 1 >= 0 && y - 1 < 8) {
                moveTo.add(new ChessboardPoint(x, y - 1));
            }
        }
        return moveTo;
    }

    @Override


    public String toString() {
        if (name == 'p') {
            return "p";
        } else {
            return "P";
        }
    }
}
