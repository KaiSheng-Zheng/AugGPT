
public class Chessboard {
    private ChessComponent[][] Board = new ChessComponent[8][8];

    public Chessboard() {
    }

    public void setBoard(ChessComponent Chess, ChessboardPoint point) {
        Board[point.getX()][point.getY()] = Chess;
    }

    public ChessComponent[][] getBoard() {
        return Board;
    }

    public ChessComponent getChess(ChessboardPoint point){
        return Board[point.getX()][point.getY()];
    }

}
