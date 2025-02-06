import java.util.List;

public interface ChessGame {
    // This abstract method loads chess game from given chessboard.
    void loadChessGame(List<String> chessboard);

    // This abstract method returns the current player.
    ChessColor getCurrentPlayer();

    // This abstract method returns the ChessComponent object in the given position.
    ChessComponent getChess(int x, int y);

    // This abstract method returns the chessboard status.
    String getChessboardGraph();

    // This abstract method returns all the chess pieces that are already captured.
    String getCapturedChess(ChessColor player);

    List<ChessboardPoint> getCanMovePoints(ChessboardPoint source);

    boolean moveChess(int sourceX, int sourceY, int targetX, int targetY);
}
