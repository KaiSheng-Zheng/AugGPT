import java.util.List;

public interface ChessGame {
    //This class provides a rough description for running a chess game.
    //Abstract methods should be left in abstract form for further implementation,
    //you don't need to write codes for them in detail.

    /**
     * This abstract method loads chess game from given chessboard.
     * @param chessboard
     */
    void loadChessGame(List<String> chessboard);

    /**
     * This abstract method returns the current player.
     * @return
     */
    ChessColor getCurrentPlayer();

    /**
     * This abstract method returns the ChessComponent object in the given position.
     * @param x
     * @param y
     * @return
     */
    ChessComponent getChess(int x, int y);

    /**
     * This abstract method returns the chessboard status.
     * @return
     */
    String getChessboardGraph();

    /**
     * This abstract method returns all the chess pieces that are already captured.
     * @param player
     * @return
     */
    String getCapturedChess(ChessColor player);


    List<ChessboardPoint> getCanMovePoints(ChessboardPoint source);


    boolean moveChess(int sourceX, int sourceY, int targetX, int targetY);

}
