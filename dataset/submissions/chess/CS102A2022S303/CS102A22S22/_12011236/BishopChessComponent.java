import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessColor chessColor, char name) {
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
        allPossibleMove.addAll(Objects.requireNonNull(searchPossibleMoveDirection(-1,-1,chessBoard)));
        allPossibleMove.addAll(Objects.requireNonNull(searchPossibleMoveDirection(-1,1,chessBoard)));
        allPossibleMove.addAll(Objects.requireNonNull(searchPossibleMoveDirection(1,1,chessBoard)));
        allPossibleMove.addAll(Objects.requireNonNull(searchPossibleMoveDirection(1,-1,chessBoard)));
        return allPossibleMove;
    }
}
