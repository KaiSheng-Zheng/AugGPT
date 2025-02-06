import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {

    public RookChessComponent(ChessboardPoint point, ChessColor chessColor, char name) {
        super(point, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> needToReturn = new ArrayList<>();

        ChessboardPoint source = this.getSource();

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (x!=source.getX()&y!=source.getY()){
                    if (this.canMoveTo(chessComponents,new ChessboardPoint(x,y))){
                        needToReturn.add(new ChessboardPoint(x,y));
                    }
                }
            }
        }

        return needToReturn;
    }


    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {

        ChessboardPoint source = this.getSource();

        if (source.getX() == destination.getX()) {
            int row = source.getX();
            for (int col = Math.min(source.getY(), destination.getY()) + 1;
                 col < Math.max(source.getY(), destination.getY()); col++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        }
        else if (source.getY() == destination.getY()) {
            int col = source.getY();
            for (int row = Math.min(source.getX(), destination.getX()) + 1;
                 row < Math.max(source.getX(), destination.getX()); row++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        }
        else { // Not on the same row or the same column.
            return false;
        }

        if (chessComponents[destination.getX()][destination.getY()].getChessColor().equals(this.getChessColor())){
            return false;
        }
        return true;
    }
}
