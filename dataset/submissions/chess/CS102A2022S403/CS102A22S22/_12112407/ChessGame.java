import java.util.List;

public interface ChessGame {
    public String getCapturedChess(ChessColor player);
    public String getChessboardGraph();
    public ChessColor getCurrentPlayer();
    public void loadChessGame(List<String> chessboard);
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source);
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY);
}
