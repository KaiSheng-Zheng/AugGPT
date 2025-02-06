import java.util.List;

public interface ChessGame {
    void loadChessGame(List<String> chessboard);

    abstract ChessColor getCurrentPlayer();

    abstract ChessComponent getChess(int x, int y);

    abstract String getChessboardGraph();

    abstract public String getCapturedChess(ChessColor player);

    List<ChessboardPoint> getCanMovePoints(ChessboardPoint source);

    boolean moveChess(int sourceX, int sourceY, int targetX, int targetY);
}
