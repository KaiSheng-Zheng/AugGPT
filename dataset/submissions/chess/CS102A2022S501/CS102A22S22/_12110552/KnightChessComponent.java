import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public KnightChessComponent() {
    }

    public static ChessColor color;
    private ChessboardPoint source;

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList Move = new ArrayList();

        ChessboardPoint destination1 = new ChessboardPoint(source.getX() - 1, source.getY() - 2);
        if (0 <= destination1.getX() && destination1.getX() <= 7 && 0 <= destination1.getY() && destination1.getY() <= 7) {
            if (destination1 != null) {
                if (chessboard[source.getX()][source.getY()].getChessColor() != chessboard[source.getX() - 1][source.getY() - 2].getChessColor()) {
                    Move.add(destination1);
                }
            }
        }
        ChessboardPoint destination2 = new ChessboardPoint(source.getX() - 1, source.getY() + 2);
        if (0 <= destination2.getX() && destination2.getX() <= 7 && 0 <= destination2.getY() && destination2.getY() <= 7) {
            if (destination2 != null) {
                if (chessboard[source.getX()][source.getY()].getChessColor() != chessboard[source.getX() - 1][source.getY() + 2].getChessColor()) {
                    Move.add(destination2);
                }
            }
        }
        ChessboardPoint destination3 = new ChessboardPoint(source.getX() + 1, source.getY() - 2);
        if (0 <= destination3.getX() && destination3.getX() <= 7 && 0 <= destination3.getY() && destination3.getY() <= 7) {
            if (destination3 != null) {
                if (chessboard[source.getX()][source.getY()].getChessColor() != chessboard[source.getX() + 1][source.getY() - 2].getChessColor()) {
                    Move.add(destination3);
                }
            }
        }
        ChessboardPoint destination4 = new ChessboardPoint(source.getX() + 1, source.getY() + 2);
        if (0 <= destination4.getX() && destination4.getX() <= 7 && 0 <= destination4.getY() && destination4.getY() <= 7) {
            if (destination4 != null) {
                if (chessboard[source.getX()][source.getY()].getChessColor() != chessboard[source.getX() + 1][source.getY() + 2].getChessColor()) {
                    Move.add(destination4);
                }
            }
        }
        ChessboardPoint destination5 = new ChessboardPoint(source.getX() - 2, source.getY() - 1);
        if (0 <= destination5.getX() && destination5.getX() <= 7 && 0 <= destination5.getY() && destination5.getY() <= 7) {
            if (destination5 != null) {
                if (chessboard[source.getX()][source.getY()].getChessColor() != chessboard[source.getX() - 2][source.getY() - 1].getChessColor()) {
                    Move.add(destination5);
                }
            }
        }
        ChessboardPoint destination6 = new ChessboardPoint(source.getX() - 2, source.getY() + 1);
        if (0 <= destination6.getX() && destination6.getX() <= 7 && 0 <= destination6.getY() && destination6.getY() <= 7) {
            if (destination6 != null) {
                if (chessboard[source.getX()][source.getY()].getChessColor() != chessboard[source.getX() - 2][source.getY() + 1].getChessColor()) {
                    Move.add(destination6);
                }
            }
        }
        ChessboardPoint destination7 = new ChessboardPoint(source.getX() + 2, source.getY() - 1);
        if (0 <= destination7.getX() && destination7.getX() <= 7 && 0 <= destination7.getY() && destination7.getY() <= 7) {
            if (destination7 != null) {
                if (chessboard[source.getX()][source.getY()].getChessColor() != chessboard[source.getX() + 2][source.getY() - 1].getChessColor()) {
                    Move.add(destination7);
                }
            }
        }
        ChessboardPoint destination8 = new ChessboardPoint(source.getX() + 2, source.getY() + 1);
        if (0 <= destination8.getX() && destination8.getX() <= 7 && 0 <= destination8.getY() && destination8.getY() <= 7) {
            if (destination8 != null) {
                if (chessboard[source.getX()][source.getY()].getChessColor() != chessboard[source.getX() + 2][source.getY() + 1].getChessColor()) {
                    Move.add(destination8);
                }
            }
        }
        if (Move.isEmpty()) {
            return new ArrayList<>();
        } else {
            return Move;
        }
    }
}
