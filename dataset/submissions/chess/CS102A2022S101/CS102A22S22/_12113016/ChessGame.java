import java.util.List;

public interface ChessGame {

    public void loadChessGame(List<String> chessboard);


    public ChessColor getCurrentPlayer();


    public ChessComponent getChess(int x, int y);


    public String getChessboardGraph();


    public String getCapturedChess(ChessColor player);


    List<ChessboardPoint> getCanMovePoints(ChessboardPoint source);


    boolean moveChess(int sourceX, int sourceY, int targetX, int targetY);


}
