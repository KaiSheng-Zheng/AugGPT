import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {

    public QueenChessComponent(int x, int y, char ming) {

        this.setSource(new ChessboardPoint(x, y));

        if (ming == 'Q') {
            setChessColor(ChessColor.BLACK);
            this.name = 'Q';

        } else if (ming == 'q') {
            setChessColor(ChessColor.WHITE);
            this.name = 'q';

        } else {
            setChessColor(ChessColor.NONE);
        }


    }

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
            if (source.getX() == destination.getX()) {
                int row = source.getX();
                for (int col = Math.min(source.getY(), destination.getY()) + 1; col < Math.max(source.getY(), destination.getY()); col++) {
                    if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            } else if (source.getY() == destination.getY()) {
                int col = source.getY();
                for (int row = Math.min(source.getX(), destination.getX()) + 1;
                     row < Math.max(source.getX(), destination.getX()); row++) {
                    if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            } else if (source.getX() - source.getY() == destination.getX() - destination.getY()) {
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
            } else {
                return false;
            }
            return true;
        }
        else {
            return false;
        }
    }
}