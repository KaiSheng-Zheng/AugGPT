import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent  {

    public QueenChessComponent(int x, int y, char name, ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
        source = new ChessboardPoint(x, y);
        super.name = name;
        if (name == 'Q')
            chessColor = ChessColor.BLACK;
        else if (name == 'q')
            chessColor = ChessColor.WHITE;

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> chessboardPoints = new ArrayList<>();
        for (int x = 0; x < 8; x++)
            for (int y = 0; y < 8; y++) {
                ChessboardPoint destination = new ChessboardPoint(x, y);
                if (CMT(destination))
                    chessboardPoints.add(destination);
            }
        return chessboardPoints;
    }

    public boolean CMT(ChessboardPoint destination) {
        if (chessComponents[destination.getX()][destination.getY()].chessColor != chessColor) {
            if (source.getX() - destination.getX() == -source.getY() + destination.getY()) {
                int row_max = Math.max(source.getX(), destination.getX());
                int col_min = Math.min(source.getY(), destination.getY());
                for (int col = Math.min(source.getY(), destination.getY()) + 1; col < Math.max(source.getY(), destination.getY()); col++) {
                    int i = col - col_min;
                    if (!(chessComponents[row_max - i][col] instanceof EmptySlotComponent))
                        return false;
                }
            } else if (source.getX() - destination.getX() == source.getY() - destination.getY()) {
                int row_min = Math.min(source.getX(), destination.getX());
                int col_min = Math.min(source.getY(), destination.getY());
                for (int col = Math.min(source.getY(), destination.getY()) + 1; col < Math.max(source.getY(), destination.getY()); col++) {
                    int i = col - col_min;
                    if (!(chessComponents[row_min + i][col] instanceof EmptySlotComponent))
                        return false;
                }
            } else if (source.getX() == destination.getX()) {
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
            } else { // Not on the same row or the same column.
                return false;
            }
            return true;
        }
        return false;
    }
}
