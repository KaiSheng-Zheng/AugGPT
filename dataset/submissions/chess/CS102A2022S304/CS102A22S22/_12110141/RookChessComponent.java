import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(int x, int y, char ming) {

        this.setSource(new ChessboardPoint(x, y));

        if (ming == 'R') {
            setChessColor(ChessColor.BLACK);

            this.name = 'R';

        } else if (ming == 'r') {
            setChessColor(ChessColor.WHITE);
            this.name = 'r';

        } else {
            setChessColor(ChessColor.NONE);
        }

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(canMoveTo(chessboard, new ChessboardPoint(i,j))){
                    canMoveTo.add(new ChessboardPoint(i,j));
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
                for (int col = Math.min(source.getY(), destination.getY()) + 1;//ensure it can't yue zi
                     col < Math.max(source.getY(), destination.getY()); col++) {
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
            } else { // Not on the same row or the same column.
                return false;
            }
            return true;
        }
        else {
            return false;
        }
    }

}
