import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessComponent[][] board, ChessboardPoint point, ChessColor side) {
        super(board);
        setSource(point);
        setChessColor(side);
        name = side == ChessColor.BLACK? 'P' : 'p';
    }

    public boolean isMoved() {
        return !((getChessColor() == ChessColor.BLACK && getSource().getX() == 1) || (getChessColor() == ChessColor.WHITE && getSource().getX() == 6));
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> pattern = new ArrayList<>();

        int offset = getChessColor() == ChessColor.BLACK ? 1 : -1;
        int offset2 = getChessColor() == ChessColor.BLACK ? 2 : -2;

        try {
            if (board[getSource().getX() + offset][getSource().getY()] instanceof EmptySlotComponent) {
                pattern.add(getSource().offset(offset, 0));
            }
        } catch (IndexOutOfBoundsException ignored) {

        }

        try {
            if (!isMoved() && !pattern.isEmpty() && board[getSource().getX() + offset2][getSource().getY()] instanceof EmptySlotComponent) {
                pattern.add(getSource().offset(offset2, 0));
            }
        } catch (IndexOutOfBoundsException ignored) {

        }

        try {
            ChessComponent piece = board[getSource().getX() + offset][getSource().getY() - 1];
            if (!(piece instanceof EmptySlotComponent) && piece.getChessColor() != getChessColor()) {
                pattern.add(getSource().offset(offset, -1));
            }
        } catch (IndexOutOfBoundsException ignored) {

        }

        try {
            ChessComponent piece = board[getSource().getX() + offset][getSource().getY() + 1];
            if (!(piece instanceof EmptySlotComponent) && piece.getChessColor() != getChessColor()) {
                pattern.add(getSource().offset(offset, 1));
            }
        } catch (IndexOutOfBoundsException ignored) {

        }

        return pattern;
    }
}