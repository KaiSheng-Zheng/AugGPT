import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessGame chessGame;

    public void setChessGame(ChessGame chessGame) {
        this.chessGame = chessGame;
    }

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    //    //should design
    public ChessComponent() {
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public boolean canPlaced(ChessboardPoint src, ChessboardPoint dst) {
        ChessComponent[][] board = chessGame.getChessComponents();
        if (isEmptyChess(dst))
            return true;
        if (isOpposite(src, dst))
            return true;
        return false;
    }
public boolean isMate(ChessboardPoint src, ChessboardPoint dst) {
        ChessComponent[][] board = chessGame.getChessComponents();
        ChessComponent chess = board[src.getX()][src.getY()];
        ChessComponent chess2 = board[dst.getX()][dst.getY()];
   if(chess.getChessColor().equals(chess2.getChessColor()))
       return true;
   return false;
}
    public boolean isOpposite(ChessboardPoint src, ChessboardPoint dst) {
        ChessComponent[][] board = chessGame.getChessComponents();
        ChessColor my = board[dst.getX()][dst.getY()].getChessColor();
        ChessColor you = board[src.getX()][src.getY()].getChessColor();
        if (my.equals(ChessColor.WHITE) && you.equals(ChessColor.BLACK))
            return true;
        if (my.equals(ChessColor.BLACK) && you.equals(ChessColor.WHITE))
            return true;
        return false;
    }

    public boolean isEmptyChess(ChessboardPoint point) {
        ChessComponent[][] board = chessGame.getChessComponents();
        return board[point.getX()][point.getY()].name == '_';
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     *
     * @return
     */
    @Override
    public String toString() {
        return "" + name;
//        return "ChessComponent{" +
//                "source=" + source +
//                ", chessColor=" + chessColor +
//                ", name=" + name +
//                '}';
    }
}
