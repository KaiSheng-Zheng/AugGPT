import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {

    public KnightChessComponent(int x, int y, ChessColor chessColor) {
        this.setSource(new ChessboardPoint(x, y));
        this.setChessColor(chessColor);
        this.name = chessColor.equals(ChessColor.BLACK) ? 'N' : 'n';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> availablePoints = new ArrayList<ChessboardPoint>();
        ChessGame chessGame = ConcreteChessGame.getInstance();
        int x = getSource().getX(), y = getSource().getY();
        ChessComponent[] possibleChess = {
                chessGame.getChess(x + 2, y + 1),
                chessGame.getChess(x + 2, y - 1),
                chessGame.getChess(x - 2, y + 1),
                chessGame.getChess(x - 2, y - 1),
                chessGame.getChess(x - 1, y + 2),
                chessGame.getChess(x + 1, y + 2),
                chessGame.getChess(x - 1, y - 2),
                chessGame.getChess(x + 1, y - 2)
        };

        for (ChessComponent chess : possibleChess) {
            if (chess != null && chess.getChessColor() != getChessColor()) {
                availablePoints.add(chess.getSource());
            }
        }

        return availablePoints;
    }
}
