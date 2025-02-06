import java.util.List;

public interface ChessGame {

    void loadChessGame(List<String> chessboard);

    ChessColor getCurrentPlayer();

    ChessComponent getChess(int x, int y);

    String getChessboardGraph();

    public String getCapturedChess(ChessColor player);

    List<ChessboardPoint> getCanMovePoints(ChessboardPoint source);
    //return all can move points according to the rules in concrete chess components respectively,
    //If no ChessboardPoint can be moved to, return a reference of empty List instead of null.

    boolean moveChess(int sourceX, int sourceY, int targetX, int targetY);
    //This abstract method returns whether a chess piece at source can move to target.

}