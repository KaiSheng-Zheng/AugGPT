import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(int x, int y, ChessColor chessColor) {
        super(x, y, chessColor);
        if (chessColor == ChessColor.BLACK) {
            name = 'P';
        } else {
            name = 'p';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMove = new ArrayList<>();
        int y = super.getSource().getY();
        int x = super.getSource().getX();
        if (super.getChessColor() == ChessColor.WHITE) {
            if (x >= 1) {
                if (x == 6 && chessboard[x-2][y].toString().equals("_")) {
                    canMove.add(super.getSource().offset(-2, 0));
                }
                if (y != 0 && chessboard[x - 1][y - 1].getChessColor() == ChessColor.BLACK) {
                    canMove.add(super.getSource().offset(-1, -1));
                }
                if (chessboard[x-1][y].toString().equals("_")) {
                    canMove.add(super.getSource().offset(-1, 0));
                }
                if (y != 7 && chessboard[x - 1][y + 1].getChessColor() == ChessColor.BLACK) {
                    canMove.add(super.getSource().offset(-1, 1));
                }
            }
        } else {
            if (x <= 6) {
                if (y != 0 && chessboard[x + 1][y - 1].getChessColor() == ChessColor.WHITE) {
                    canMove.add(super.getSource().offset(1, -1));
                }
                if (chessboard[x+ 1][y].toString().equals("_")) {
                    canMove.add(super.getSource().offset(+1, 0));
                }
                if (y != 7 && chessboard[x + 1][y + 1].getChessColor() == ChessColor.WHITE) {
                    canMove.add(super.getSource().offset(1, 1));
                }
                if (x == 1 && chessboard[x+ 2][y].toString().equals("_")) {
                    canMove.add(super.getSource().offset(2, 0));
                }
            }
        }
        return canMove;
    }
}
