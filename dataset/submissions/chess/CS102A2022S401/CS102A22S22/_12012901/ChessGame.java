import java.util.List;

public interface ChessGame {


    public void loadChessGame(List<String> chessboard);

    public ChessColor getCurrentPlayer();

    public ChessComponent getChess(int x, int y);



    public String getChessboardGraph();


    public String getCapturedChess(ChessColor player);


    public default List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        return getChess(source.getX(),source.getY()).canMoveTo();
    }


    public  default boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        return getChess(sourceX,sourceY).canMoveTo().contains(getChess(targetX,targetY).getSource());
    }

}
