import java.util.List;

public interface ChessGame {
    /***This class provides a rough description for running a chess game.
     Abstract methods should be left in abstract form for further implementation,
     you don't need to write codes for them in detail.
     */
    ChessColor currentColor = ChessColor.BLACK;

    //This abstract method loads chess game from given chessboard.
    abstract void loadChessGame(List<String> chessboard);

    //This abstract method returns the current player.
    abstract ChessColor getCurrentPlayer();


    //This abstract method returns the ChessComponent object in the given position.
    public abstract ChessComponent getChess(int x, int y);


    //This abstract method returns the chessboard status.
    abstract String getChessboardGraph();


    //This abstract method returns all the chess pieces that are already captured.
    public abstract String getCapturedChess(ChessColor player);

    //This abstract method returns whether a chess piece at source can move to target. Detailed method is shown as follows.
     boolean moveChess(int sourceX, int sourceY, int targetX, int targetY);
    //This abstract method returns all the points that chess piece at "source" point can move to.
    List<ChessboardPoint> getCanMovePoints(ChessboardPoint source);

}

