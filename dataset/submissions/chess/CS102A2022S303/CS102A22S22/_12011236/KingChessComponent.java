import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessColor chessColor, char name) {
        super(chessColor, name);
    }

    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] chessBoard = ConcreteChessGame.getChessBoard();
        List<ChessboardPoint> allPossibleMove = new ArrayList<>();
        int row = super.getSource().getX();
        int column = super.getSource().getY();
        if (!(row > -1 && row < 8 && column > -1 && column < 8)) {
            return new ArrayList<>();
        }
        for (int i = row - 1; i < row + 2; i++) {
            for (int j = column - 1; j < column + 2; j++) {
                if (i >= 0 && i <= 7 && j >= 0 && j <= 7) {
                    if (chessBoard[i][j].name=='_') {
                        allPossibleMove.add(possibleMoveOfChess(i, j));
                    } else {
                        if (chessBoard[i][j].getChessColor() != this.getChessColor()) {
                            allPossibleMove.add(possibleMoveOfChess(i, j));
                        }
                    }
                }
            }
        }
        return allPossibleMove;
    }
}
