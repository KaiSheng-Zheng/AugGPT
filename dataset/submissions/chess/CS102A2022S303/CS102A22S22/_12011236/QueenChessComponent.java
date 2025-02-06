import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessColor chessColor, char name) {
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
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                allPossibleMove.addAll(Objects.requireNonNull(searchPossibleMoveDirection( i, j, chessBoard)));
            }
        }
        return allPossibleMove;
    }
}
