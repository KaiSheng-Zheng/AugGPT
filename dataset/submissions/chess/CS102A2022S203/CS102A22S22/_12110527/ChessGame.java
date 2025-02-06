import java.util.List;

public abstract interface ChessGame {
       abstract void loadChessGame(List<String> chessboard);
       abstract ChessColor getCurrentPlayer();
       abstract ChessComponent getChess(int x, int y);
       abstract String getChessboardGraph();
       public abstract String getCapturedChess(ChessColor player);
       abstract List<ChessboardPoint> getCanMovePoints(ChessboardPoint source);
       abstract boolean moveChess(int sourceX, int sourceY, int targetX, int targetY);
}
