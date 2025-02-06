import java.util.List;

public interface ChessGame {
  abstract void loadChessGame(List<String> chessboard);
    abstract ChessColor getCurrentPlayer();
    abstract String getChessboardGraph();
    abstract String getCapturedChess(ChessColor player);
  abstract ChessComponent getChess(int x, int y);
  public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source);

  public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY);

}
