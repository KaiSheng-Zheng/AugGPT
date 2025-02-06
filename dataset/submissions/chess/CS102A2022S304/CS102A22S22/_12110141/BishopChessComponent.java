import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {


    public BishopChessComponent(int x, int y, char ming) {
        setSource(new ChessboardPoint(x, y));
        if (ming == 'B') {
            setChessColor(ChessColor.BLACK);
            this.name = 'B';

        } else if (ming == 'b') {
            setChessColor(ChessColor.WHITE);
            this.name = 'b';

        } else {
            setChessColor(ChessColor.NONE);
        }

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (canMoveTo(chessboard, new ChessboardPoint(i, j))) {
                    canMoveTo.add(new ChessboardPoint(i, j));
                }
            }
        }
        return canMoveTo;

    }

    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getSource();
        if (chessComponents[destination.getX()][destination.getY()].getChessColor() != this.getChessColor()) {
            if (source.getX() - source.getY() == destination.getX() - destination.getY()) {
                int col;
                int row;
                for (row = Math.min(source.getX(), destination.getX()) + 1, col = Math.min(source.getY(), destination.getY()) + 1; row < Math.max(source.getX(), destination.getX()); row++, col++) {
                    if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            } else if (source.getX() + source.getY() == destination.getX() + destination.getY()) {
                int row = Math.max(source.getX(), destination.getX()) - 1;
                int col = Math.min(source.getY(), destination.getY()) + 1;
                for (; col < Math.max(source.getY(), destination.getY()); row--, col++) {
                    if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            } else { // Not on the  same diagonal.
                return false;
            }
            return true;
        } else {
            return false;
        }

    }
}