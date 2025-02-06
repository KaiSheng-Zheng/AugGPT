import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    private final int initialX;
    private final int initialY;

    public PawnChessComponent(int x, int y, ChessColor chessColor) {
        this.setSource(new ChessboardPoint(x, y));
        this.setChessColor(chessColor);
        this.name = chessColor.equals(ChessColor.BLACK) ? 'P' : 'p';
        this.initialX = x;
        this.initialY = y;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> availablePoints = new ArrayList<ChessboardPoint>();

        // whether the chess can move toward:
        int forwardFactor = getChessColor() == ChessColor.BLACK ? 1 : -1;
        ChessGame chessGame = ConcreteChessGame.getInstance();


        ChessComponent aheadChess = chessGame.getChess(getSource().getX() + forwardFactor,
                getSource().getY());
        if (aheadChess instanceof EmptySlotComponent) {
            availablePoints.add(aheadChess.getSource());

            if ((getChessColor() == ChessColor.WHITE && getSource().getX() == 6) ||
                    (getChessColor() == ChessColor.BLACK && getSource().getX() == 1)) {
                ChessComponent aheadChess2 = chessGame.getChess(getSource().getX() + 2 * forwardFactor,
                        getSource().getY());

                if (aheadChess2 instanceof EmptySlotComponent) {
                    availablePoints.add(aheadChess2.getSource());
                }
            }
        }

        // whether the chess can eat other chess;
        ChessComponent[] diagonalChess = {
                chessGame.getChess(getSource().getX() + forwardFactor, getSource().getY() + 1),
                chessGame.getChess(getSource().getX() + forwardFactor, getSource().getY() - 1)
        };

        for (ChessComponent chess : diagonalChess) {
            if (chess != null && !(chess instanceof EmptySlotComponent) && chess.getChessColor() != this.getChessColor()) {
                availablePoints.add(chess.getSource());
            }
        }

        return availablePoints;
    }
}
