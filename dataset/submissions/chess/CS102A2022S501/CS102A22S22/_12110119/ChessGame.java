import java.util.List;

interface ChessGame {

   abstract void loadChessGame(List<String> chessboard);
    abstract ChessColor getCurrentPlayer();
    abstract ChessComponent getChess(int x, int y);
    abstract String getChessboardGraph();
    public abstract String getCapturedChess(ChessColor player);
    public abstract boolean moveChess(int sourceX, int sourceY, int targetX, int targetY);
    public abstract List<ChessboardPoint> getCanMovePoints(ChessboardPoint source);
}
