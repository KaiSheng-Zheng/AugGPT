import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    public RookChessComponent(ChessboardPoint source, char name, ConcreteChessGame chessGame) {
        super(source, name, chessGame);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> cbp = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (canMoveTo(getChessGame().getChessComponents(),new ChessboardPoint(i,j))) {
                    cbp.add(new ChessboardPoint(i,j));
                }
            }
        }
        return cbp;
    }

    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getSource();
        if (source.getX() == destination.getX()) {
            int row = source.getX();
            for (int col = Math.min(source.getY(), destination.getY()) + 1;
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
        } else {
            return false;
        }
        if (chessComponents[source.getX()][source.getY()].getChessColor()==chessComponents[destination.getX()][destination.getY()].getChessColor()) {
            return false;
        }
        return true;
    }

}
