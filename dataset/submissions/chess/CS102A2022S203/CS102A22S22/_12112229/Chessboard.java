public class Chessboard {
    protected static ChessComponent[][] chessboard= new ChessComponent[8][8];
    public static ChessComponent getChess(int x, int y) {
        return chessboard[x][y];
    }
}
