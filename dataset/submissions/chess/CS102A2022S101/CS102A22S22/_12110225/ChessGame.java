import java.util.List;
import java.util.Objects;

public interface ChessGame {
    public abstract void loadChessGame(List<String> chessboard);
    public abstract void setCurrentPlayer(ChessColor chessColor);
    public abstract ChessColor getCurrentPlayer();
    public abstract ChessComponent getChess(int x, int y);
    public abstract String getChessboardGraph();
    public abstract String getCapturedChess(ChessColor Player);
    public abstract boolean moveChess(int sourceX, int sourceY, int targetX, int targetY);
    public abstract List<ChessboardPoint> getCanMovePoints(ChessboardPoint source);

}
