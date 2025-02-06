import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private boolean isMoved = false;

    //should design
    public ChessComponent(){}

    public ChessComponent(ChessColor chessColor, char name) {
        this.chessColor = chessColor;
        this.name = name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessboardPoint possibleMove(int x, int y) {
        return source.offset(x, y);
    }

    public List<ChessboardPoint> searchPossibleMoveDirection(int rowDirection, int colDirection, ChessComponent[][] chessBoard) {
            List<ChessboardPoint> allPossibleMove = new ArrayList<>();
            int counter = 1;
            int row = this.source.getX();
            int col = this.source.getY();
            if (rowDirection >= -1 && rowDirection <= 1 && colDirection >= -1 && colDirection <= 1) {
                while (row + counter * rowDirection >= 0 && row + counter * rowDirection <= 7 && col + counter * colDirection >= 0 && col + counter * colDirection <= 7) {
                    if (chessBoard[row + counter * rowDirection][col + counter * colDirection].name=='_') {
                        allPossibleMove.add(possibleMoveOfChess(row + counter * rowDirection, col + counter * colDirection));
                    } else {
                        if (chessBoard[row + counter * rowDirection][col + counter * colDirection].getChessColor() != this.getChessColor()) {
                            allPossibleMove.add(possibleMoveOfChess(row + counter * rowDirection, col + counter * colDirection));
                        }
                        break;
                    }
                    counter++;
                }
            }
            return allPossibleMove;
    }

    public static ChessboardPoint possibleMoveOfChess(int row, int column) {
        if (row>=0&&row<=7&&column>=0&&column<=7){
            return new ChessboardPoint(row,column);
        }else {
            return null;
        }
    }

    public static boolean isNullOrReverseColor(ChessColor chessColor, int row, int col, ChessComponent[][] chessBoard) {
        return chessBoard[row][col].name=='_' || chessBoard[row][col].getChessColor() != chessColor;
    }

    public boolean isMoved() {
        return isMoved;
    }

    public void updateIsMoved() {
        isMoved = true;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
