import java.util.List;

/**
 * This class provides a rough description for running a chess game.
 * Abstract methods should be left in abstract form for further implementation,
 * you don't need to write codes for them in detail.
 */
public interface ChessGame {


    // Abstract Methods

    /**
     * This abstract method loads chess game from given chessboard.
     *
     * @param chessboard
     */
    public void loadChessGame(List<String> chessboard);


    /**
     * This abstract method returns the current player.
     *
     * @return
     */
    public ChessColor getCurrentPlayer();


    /**
     * This abstract method returns the ChessComponent object in the given position.
     *
     * @param x
     * @param y
     * @return
     */
    public ChessComponent getChess(int x, int y);


    /**
     * This abstract method returns the chessboard status.
     *
     * @return
     */
    public String getChessboardGraph();


    /**
     * This abstract method returns all the chess pieces that are already captured.
     *
     * @param player
     * @return
     */
    public String getCapturedChess(ChessColor player);


    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source);


    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY);

}