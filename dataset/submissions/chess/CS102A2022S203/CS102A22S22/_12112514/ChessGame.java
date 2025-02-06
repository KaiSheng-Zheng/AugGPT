

import java.util.List;

public  interface ChessGame {
   public abstract void loadChessGame(List<String> chessboard);
   //This abstract method loads chess game from given chessboard.

    public abstract ChessColor getCurrentPlayer();
    //This abstract method returns the current player.

    public abstract ChessComponent getChess(int x, int y);
    //This abstract method returns the ChessComponent object in the given position.

    public abstract String getChessboardGraph();
    //This abstract method returns the chessboard status.

    public abstract  String getCapturedChess(ChessColor player); //q4
    //This abstract method returns all the chess pieces that are already captured.
    boolean moveChess(int sourceX, int sourceY, int targetX, int targetY); // q4
    List<ChessboardPoint> getCanMovePoints(ChessboardPoint source);
}


