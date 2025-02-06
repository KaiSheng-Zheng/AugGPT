import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {

    public PawnChessComponent(int x, int y, char ming) {
        setSource(new ChessboardPoint(x, y));

        if (ming == 'P') {
            setChessColor(ChessColor.BLACK);
            this.name = 'P';

        } else if (ming == 'p') {
            setChessColor(ChessColor.WHITE);
            this.name = 'p';

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
//        ChessColor color = getChessColor();
        ChessboardPoint source = getSource();
        if (chessComponents[destination.getX()][destination.getY()].getChessColor() != this.getChessColor()) {

            if (getChessColor() == ChessColor.WHITE && source.getX() == 6) {
                int col = source.getY();
                if ((destination.getX() - source.getX() == -1 || destination.getX() - source.getX() == -2) && destination.getY() == source.getY()) {
                    for (int row = destination.getX(); row <= source.getX(); row++) {
                        if ((chessComponents[row][col] instanceof EmptySlotComponent)) {
                            return true;
                        }
                    }
                }
            }
            if (getChessColor() == ChessColor.BLACK && source.getX() == 1) {
                int col = source.getY();
                if ((destination.getX() - source.getX() == 1 || destination.getX() - source.getX() == 2) && destination.getY() == source.getY()) {
                    for (int row = Math.min(source.getX(), destination.getX()) + 1;
                         row <= Math.max(source.getX(), destination.getX()); row++) {
                        if ((chessComponents[row][col] instanceof EmptySlotComponent)) {
                            return true;
                        }
                    }
                }

            }
            if (destination.getX() - source.getX() == 1 && getChessColor() == ChessColor.BLACK && destination.getY() == source.getY() && chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent) {
                return true;

            }
            if (source.getX() - destination.getX() == 1 && getChessColor() == ChessColor.WHITE && destination.getY() == source.getY() && chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent) {
                return true;

            }
            if (destination.getX() - source.getX() == 1 && Math.abs(destination.getY() - source.getY()) == 1 && getChessColor() == ChessColor.BLACK && !(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                return true;
            }
            if (Math.abs(source.getY() - destination.getY()) == 1 && source.getX() - destination.getX() == 1 && getChessColor() == ChessColor.WHITE && !(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                return true;
            }

            return false;
        } else {
            return false;
        }

    }
}