import java.util.List;

public interface ChessGame {
    /*
For an example, look at the chessboard below
(Just an example for better understanding, not input format)
x\y 0 1 2 3 4 5 6 7
0 R N B Q K B N R
1 P P P P P P P P
2 _ _ _ _ _ _ _ _
3 _ _ _ _ _ _ _ _
4 _ _ _ _ _ _ _ _
5 _ _ _ _ _ _ _ _
6 p p p p p p p p
7 r n b q k b n r
*/
    void loadChessGame(List<String> chessboard);
    ChessColor getCurrentPlayer();
    ChessComponent getChess(int x, int y);
    String getChessboardGraph();
    public String getCapturedChess(ChessColor player);

    List<ChessboardPoint> getCanMovePoints(ChessboardPoint source);
    boolean moveChess(int sourceX, int sourceY, int targetX, int targetY);
}
