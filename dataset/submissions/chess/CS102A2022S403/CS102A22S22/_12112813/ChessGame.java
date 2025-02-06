import java.util.List;

public interface ChessGame {

    public void loadChessGame(List<String> chessboard);//loads chess game from given chessboard


    public ChessColor getCurrentPlayer();//return current player


    public ChessComponent getChess(int x, int y);//return ChessComponent object


    public String getChessboardGraph();//return chessboard status


    public String getCapturedChess(ChessColor player);//return chess pieces already captured


    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source);


    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY);

}
