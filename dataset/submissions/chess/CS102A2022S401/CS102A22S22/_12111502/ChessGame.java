import java.util.List;

public interface ChessGame {
    public void loadChessGame(List<String>chessboard);
    public ChessColor getCurrentPlayer();
    ChessComponent getChess(int x,int y);
    String getChessboardGraph();
    public String getCapturedChess(ChessColor player);
    boolean moveChess(int sourceX,int sourceY,int targetX,int targetY);
}