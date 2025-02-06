import java.util.List;
public interface ChessGame {
    public void loadChessGame(List<String> chessboard);
    public ChessColor getCurrentPlayer();
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint chessboardPoint);
    public ChessComponent getChess(int x, int y);
    public  String getChessboardGraph() ;
    public  String getCapturedChess(ChessColor player);
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY);

}
