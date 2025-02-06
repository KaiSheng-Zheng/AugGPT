import java.util.List;

interface ChessGame {
     void loadChessGame(List<String> chessboard);//This abstract method loads chess game from given chessboard.
     ChessColor getCurrentPlayer();//This abstract method returns the current player.
     ChessComponent getChess(int x, int y);//This abstract method returns the ChessComponent object in the given position
     String getChessboardGraph();//This abstract method returns the chessboard status
     String getCapturedChess(ChessColor player);//This abstract method returns all the chess pieces that are already captured
     boolean moveChess(int sourceX, int sourceY, int targetX, int targetY);
     List<ChessboardPoint> getCanMovePoints(ChessboardPoint source);
}