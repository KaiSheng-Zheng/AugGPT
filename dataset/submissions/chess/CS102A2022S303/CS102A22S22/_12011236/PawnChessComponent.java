import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessColor chessColor, char name) {
        super(chessColor, name);
    }

    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] chessBoard = ConcreteChessGame.getChessBoard();
        List<ChessboardPoint> allPossibleMove = new ArrayList<>();
        int row = getSource().getX();
        int column = getSource().getY();
        ChessColor chessColor = this.getChessColor();
        if (!(row > -1 && row < 8 && column > -1 && column < 8)) {
            return new ArrayList<>();
        }
        int pawnRow = chessColor == ChessColor.WHITE ? row - 1 : row + 1;
        int pawnRow1 = chessColor == ChessColor.WHITE ? row - 2 : row + 2;
        if (pawnRow1 > -1 && pawnRow1 < 8 && chessBoard[pawnRow][column].name == '_' && chessBoard[pawnRow1][column].name == '_' && !isMoved()) {
            allPossibleMove.add(possibleMoveOfChess(pawnRow1, column));
        }
        if (pawnRow >= 0 && pawnRow <= 7 && chessBoard[pawnRow][column].name == '_') {
            allPossibleMove.add(possibleMoveOfChess(pawnRow, column));
        }
        if (pawnRow >= 0 && pawnRow <= 7) {
            if (column - 1 >= 0 && chessBoard[pawnRow][column - 1].name != '_' && chessBoard[pawnRow][column-1].getChessColor() != chessColor) {
                allPossibleMove.add(possibleMoveOfChess(pawnRow, column - 1));
            }
            if (column + 1 < 8 && chessBoard[pawnRow][column + 1].name != '_' && chessBoard[pawnRow][column+1].getChessColor() != chessColor) {
                allPossibleMove.add(possibleMoveOfChess(pawnRow, column + 1));
            }
        }
        return allPossibleMove;
    }
}
