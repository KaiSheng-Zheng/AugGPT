import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {

    public BishopChessComponent(ChessColor chessColor, ChessboardPoint source) {
        super(chessColor, source);
        if (chessColor.equals(ChessColor.BLACK)) {
            this.name = 'B';
        } else {
            this.name = 'b';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> moveTo = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            if (source.getX() + i < 8 && source.getY() + i < 8) {
                if (super.chessboard[source.getX() + i][source.getY() + i].chessColor.equals(
                        ChessColor.NONE)) {
                    moveTo.add(new ChessboardPoint(source.getX() + i, source.getY() + i));
                }
                else if (!super.chessboard[source.getX() + i][source.getY() + i].chessColor.equals(
                        super.chessboard[source.getX()][source.getY()].chessColor)) {
                    moveTo.add(new ChessboardPoint(source.getX() + i, source.getY() + i));
                    break;
                }
                else break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (source.getX() - i >= 0 && source.getY() + i < 8) {
                if (super.chessboard[source.getX() - i][source.getY() + i].chessColor.equals(
                        ChessColor.NONE)) {
                    moveTo.add(new ChessboardPoint(source.getX() - i, source.getY() + i));
                }
                else if (!super.chessboard[source.getX() - i][source.getY() + i].chessColor.equals(
                        super.chessboard[source.getX()][source.getY()].chessColor)) {
                    moveTo.add(new ChessboardPoint(source.getX() - i, source.getY() + i));
                    break;
                }
                else break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (source.getX() - i >= 0 && source.getY() - i >= 0) {
                if (super.chessboard[source.getX() - i][source.getY() - i].chessColor.equals(
                        ChessColor.NONE)) {
                    moveTo.add(new ChessboardPoint(source.getX() - i, source.getY() - i));
                }
                else if (!super.chessboard[source.getX() - i][source.getY() - i].chessColor.equals(
                        super.chessboard[source.getX()][source.getY()].chessColor)) {
                    moveTo.add(new ChessboardPoint(source.getX() - i, source.getY() - i));
                    break;
                }
                else break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (source.getX() + i < 8 && source.getY() - i >= 0) {
                if (super.chessboard[source.getX() + i][source.getY() - i].chessColor.equals(
                        ChessColor.NONE)) {
                    moveTo.add(new ChessboardPoint(source.getX() + i, source.getY() - i));
                }
                else if (!super.chessboard[source.getX() + i][source.getY() - i].chessColor.equals(
                        super.chessboard[source.getX()][source.getY()].chessColor)) {
                    moveTo.add(new ChessboardPoint(source.getX() + i, source.getY() - i));
                    break;
                }
                else break;
            }
        }

        return moveTo;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}