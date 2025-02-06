import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

    public KingChessComponent(int x, int y, char ming) {

        setSource(new ChessboardPoint(x, y));

        if (ming == 'K') {
            setChessColor(ChessColor.BLACK);
            this.name = 'K';

        } else if (ming == 'k') {
            setChessColor(ChessColor.WHITE);
            this.name = 'k';

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
        ChessColor temp = chessComponents[destination.getX()][destination.getY()].getChessColor();
        if (chessComponents[destination.getX()][destination.getY()].getChessColor() != this.getChessColor()) {
            if (Math.abs(source.getX() - destination.getX()) == 1 && source.getY() == destination.getY()) {
                return true;
            } else if (Math.abs(source.getY() - destination.getY()) == 1 && source.getX() == destination.getX()) {
                return true;
            } else if (Math.abs((source.getY()) - destination.getY()) == 1 && Math.abs(source.getX() - destination.getX()) == 1) {
                return true;
            } else { // Not on the same row or the same column or on diagonal
                return false;
            }

        } else {
            return false;
        }
    }
}