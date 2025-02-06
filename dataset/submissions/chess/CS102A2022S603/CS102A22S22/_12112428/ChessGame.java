import java.util.List;

public interface ChessGame {

    /** This abstract method loads chess game from given chessboard. */
    public void loadChessGame(List<String> chessboard);

    /** This abstract method returns the current player */
    public ChessColor getCurrentPlayer();

    /** This abstract method returns the ChessComponent object in the given position. */
    public ChessComponent getChess(int x, int y);

    /** This abstract method returns the chessboard status. */
    public String getChessboardGraph();

    /** This abstract method returns all the chess pieces that are already captured */
    public String getCapturedChess(ChessColor player);


    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source);


    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY);

}
