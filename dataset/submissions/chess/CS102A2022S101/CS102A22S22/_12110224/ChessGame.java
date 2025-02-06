import java.util.List;

public interface ChessGame {
    void loadChessGame(List<String> chessboard);
    ChessColor getCurrentPlayer();
    //Method to Implement: getChess
    //This abstract method returns the ChessComponent object in the given position.
    ChessComponent getChess(int x, int y);
    ChessComponent[][] chessComponents = new ChessComponent[8][8];
    String getChessboardGraph();

    String getCapturedChess(ChessColor player);
    List<ChessboardPoint> getCanMovePoints(ChessboardPoint source);
}