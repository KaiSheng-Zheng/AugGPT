import java.util.List;

public interface ChessGame {
    // loads chess game from given chessboard
    public void loadChessGame(List<String> chessboard);

    // returns the current player
    public ChessColor getCurrentPlayer();

    // returns the ChessComponent object in the given position
    public ChessComponent getChess(int x, int y);

    // returns the chessboard status
    public String getChessboardGraph();

    // returns all the chess pieces that are already captured
    public String getCapturedChess(ChessColor player);

    // returns whether a chess piece at source can move to target
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY);

    // returns all the points that chess piece at "source" point can move to
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source);
}
