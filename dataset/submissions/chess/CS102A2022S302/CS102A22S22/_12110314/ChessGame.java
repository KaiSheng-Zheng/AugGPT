import java.util.List;

public interface ChessGame {
    public abstract void loadChessGame(List<String> chessboard);

    public abstract ChessColor getCurrentPlayer();

    public abstract ChessComponent getChess(int X, int Y);

    public abstract String getChessboardGraph();

    public abstract String getCapturedChess(ChessColor player);

    public abstract boolean moveChess(int sourceX,int sourceY,int targetX,int targetY);

    public abstract List<ChessboardPoint> getCanMovePoints(ChessboardPoint source);

}