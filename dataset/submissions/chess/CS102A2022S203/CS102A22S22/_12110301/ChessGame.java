import java.util.List;
public interface ChessGame {
    void loadChessGame(List<String> chessboard);
    
    ChessColor getCurrentPlayer();
    List<ChessboardPoint> getCanMovePoints(ChessboardPoint source);
    ChessComponent getChess(int x, int y);
    String getChessboardGraph();
    public String getCapturedChess(ChessColor player);
    boolean moveChess(int sourceX, int sourceY, int targetX, int targetY);

}