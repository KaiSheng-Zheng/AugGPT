import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {


    public PawnChessComponent() {

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> pawn = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        if (getChessColor() == ChessColor.WHITE) {
            if (x == 6) {
                if (chessboard[4][y].getChessColor() == ChessColor.NONE) pawn.add(new ChessboardPoint(4, y));
            }
            if (x != 0 && chessboard[x - 1][y].getChessColor() == ChessColor.NONE) {
                pawn.add(new ChessboardPoint(x - 1, y));
                if (y != 0 && chessboard[x - 1][y - 1].getChessColor() == ChessColor.BLACK) {
                    pawn.add(new ChessboardPoint(x - 1, y - 1));
                }
                if (y != 7 && chessboard[x - 1][y + 1].getChessColor() == ChessColor.BLACK) {
                    pawn.add(new ChessboardPoint(x - 1, y + 1));
                }
            }
        }
        if (getChessColor() == ChessColor.BLACK) {
            if (x == 1) {
                if (chessboard[3][y].getChessColor() == ChessColor.NONE) pawn.add(new ChessboardPoint(3, y));
            }
            if (x != 7 && chessboard[x + 1][y].getChessColor() == ChessColor.NONE) {
                pawn.add(new ChessboardPoint(x + 1, y));
                if (y != 0 && chessboard[x + 1][y - 1].getChessColor() == ChessColor.WHITE) {
                    pawn.add(new ChessboardPoint(x + 1, y - 1));
                }
                if (y != 7 && chessboard[x + 1][y + 1].getChessColor() == ChessColor.WHITE) {
                    pawn.add(new ChessboardPoint(x + 1, y + 1));
                }
            }
        }
        for (int i = 0; i < pawn.size(); i++) {
            System.out.println(pawn.get(i));
        }
        return pawn;
    }

}
