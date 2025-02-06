import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

    public KnightChessComponent(ChessColor chessColor, char name) {
        super(chessColor, name);
    }

    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] chessBoard = ConcreteChessGame.getChessBoard();
        List<ChessboardPoint> allPossibleMove = new ArrayList<>();
        int row = super.getSource().getX();
        int column = super.getSource().getY();
        ChessColor chessColor = getChessColor();
        if (!(row > -1 && row < 8 && column > -1 && column < 8)) {
            return new ArrayList<>();
        }
        if (row + 1 <= 7 && column - 2 >= 0 && isNullOrReverseColor(chessColor, row + 1, column - 2, chessBoard)) {
            allPossibleMove.add(possibleMoveOfChess(row + 1, column - 2));
        }
        if (row + 2 <= 7 && column - 1 >= 0 && isNullOrReverseColor(chessColor, row + 2, column - 1, chessBoard)) {
            allPossibleMove.add(possibleMoveOfChess(row + 2, column - 1));
        }
        if (row - 1 >= 0 && column - 2 >= 0 && isNullOrReverseColor(chessColor, row - 1, column - 2, chessBoard)) {
            allPossibleMove.add(possibleMoveOfChess(row - 1, column - 2));
        }
        if (row - 2 >= 0 && column - 1 >= 0 && isNullOrReverseColor(chessColor, row - 2, column - 1, chessBoard)) {
            allPossibleMove.add(possibleMoveOfChess(row - 2, column - 1));
        }
        if (row + 1 <= 7 && column + 2 <= 7 && isNullOrReverseColor(chessColor, row + 1, column + 2, chessBoard)) {
            allPossibleMove.add(possibleMoveOfChess(row + 1, column + 2));
        }
        if (row + 2 <= 7 && column + 1 <= 7 && isNullOrReverseColor(chessColor, row + 2, column + 1, chessBoard)) {
            allPossibleMove.add(possibleMoveOfChess(row + 2, column + 1));
        }
        if (row - 1 >= 0 && column + 2 <= 7 && isNullOrReverseColor(chessColor, row - 1, column + 2, chessBoard)) {
            allPossibleMove.add(possibleMoveOfChess(row - 1, column + 2));
        }
        if (row - 2 >= 0 && column + 1 <= 7 && isNullOrReverseColor(chessColor, row - 2, column + 1, chessBoard)) {
            allPossibleMove.add(possibleMoveOfChess(row - 2, column + 1));
        }
        return allPossibleMove;
    }
}
