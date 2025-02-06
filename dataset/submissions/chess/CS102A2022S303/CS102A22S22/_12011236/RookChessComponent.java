import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessColor chessColor, char name) {
        super(chessColor, name);
    }

    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] chessBoard = ConcreteChessGame.getChessBoard();
        List<ChessboardPoint> allPossibleMove = new ArrayList<>();
        int row = getSource().getX();
        int column = getSource().getY();
        if (!(row > -1 && row < 8 && column > -1 && column < 8)) {
            return new ArrayList<>();
        }
        allPossibleMove.addAll(Objects.requireNonNull(searchPossibleMoveDirection(-1,0,chessBoard)));
        allPossibleMove.addAll(Objects.requireNonNull(searchPossibleMoveDirection(1,0,chessBoard)));
        allPossibleMove.addAll(Objects.requireNonNull(searchPossibleMoveDirection(0,1,chessBoard)));
        allPossibleMove.addAll(Objects.requireNonNull(searchPossibleMoveDirection(0,-1,chessBoard)));
        return allPossibleMove;
    }
}
