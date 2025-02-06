import java.util.List;
public interface ChessGame {
    void loadChessGame(List<String> chessboard);
    ChessColor getCurrentPlayer();

    boolean moveChess(int sourceX, int sourceY, int targetX, int targetY);

    ChessComponent getChess(int x, int y);
    List<ChessboardPoint> getCanMovePoints(ChessboardPoint source);
    String getChessboardGraph();
    public String getCapturedChess(ChessColor player);

}
