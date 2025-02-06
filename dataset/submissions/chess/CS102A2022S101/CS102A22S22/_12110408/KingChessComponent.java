import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

    public KingChessComponent(int x, int y, ChessColor chessColor) {
        this.setSource(new ChessboardPoint(x, y));
        this.setChessColor(chessColor);
        this.name = chessColor.equals(ChessColor.BLACK) ? 'K' : 'k';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> availablePoints = new ArrayList<ChessboardPoint>();
        ChessGame chessGame = ConcreteChessGame.getInstance();
        int x = getSource().getX(), y = getSource().getY();
        ChessComponent[] possibleChess = {
                chessGame.getChess(x, y + 1),
                chessGame.getChess(x, y - 1),
                chessGame.getChess(x + 1, y + 1),
                chessGame.getChess(x + 1, y),
                chessGame.getChess(x + 1, y - 1),
                chessGame.getChess(x - 1, y + 1),
                chessGame.getChess(x - 1, y),
                chessGame.getChess(x - 1, y - 1)
        };

        for (ChessComponent chess : possibleChess) {
            if (chess != null && chess.getChessColor() != this.getChessColor()) {
                availablePoints.add(chess.getSource());
            }
        }

        return availablePoints;
    }
}
