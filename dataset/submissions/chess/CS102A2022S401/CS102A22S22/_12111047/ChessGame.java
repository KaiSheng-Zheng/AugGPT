import java.util.List;

public abstract class ChessGame {
    abstract void loadChessGame(List<String> chessboard);
    abstract ChessColor getCurrentPlayer();
    abstract ChessComponent getChess(int x, int y);
    abstract String getChessboardGraph();
    abstract public String getCapturedChess(ChessColor player);

    abstract boolean moveChess(int sourceX, int sourceY, int targetX, int targetY);

    abstract List<ChessboardPoint> getCanMovePoints(ChessboardPoint source);
}
