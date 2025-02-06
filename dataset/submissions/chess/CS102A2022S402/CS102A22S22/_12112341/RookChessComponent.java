import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {


    public RookChessComponent(ChessboardPoint chessboardPoint, ChessColor black, char r) {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> move = new ArrayList<>();
        if (source.getX() == destination.getX()) {
            int row = source.getX();
            for (int col = Math.min(source.getY(), destination.getY()) + 1;
                 col < Math.max(source.getY(), destination.getY()); col++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return new ArrayList<>();
                }else move.add(destination);
            }
        } else if (source.getY() == destination.getY()) {
            int col = source.getY();
            for (int row = Math.min(source.getX(), destination.getX()) + 1;
                 row < Math.max(source.getX(), destination.getX()); row++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return new ArrayList<>();
                }else move.add(destination);
            }
        } else {
            return new ArrayList<>();
        }
        return move;
    }
}