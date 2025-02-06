import java.util.List;

public interface ChessGame {


    public abstract void loadChessGame(List<String> chessboard);
    public abstract ChessColor getCurrentPlayer();
    public abstract ChessComponent getChess(int x, int y);
    public abstract String getChessboardGraph();
    public abstract String getCapturedChess(ChessColor player);

    boolean moveChess(int sourceX, int sourceY, int targetX, int targetY);

    List<ChessboardPoint> getCanMovePoints(ChessboardPoint source);

    
}
