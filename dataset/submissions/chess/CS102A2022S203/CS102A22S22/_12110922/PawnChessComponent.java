import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class PawnChessComponent extends ChessComponent {

    // creates a new PawnChessComponent
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor, 'P');
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();

        int dx = -1;
        int dy = 0;

        if (getChessColor() == ChessColor.BLACK) {
            dx = 1;
        }

        int x = getSource().getX() + dx;
        int y = getSource().getY() + dy;

        if (isInBoard(x, y)
                && (game.getChess(x, y) instanceof EmptySlotComponent)) {
            list.add(new ChessboardPoint(x, y));
        }

        if (isInBoard(x, y + 1)
                && !(game.getChess(x, y + 1) instanceof EmptySlotComponent)
                && (game.getChess(x, y + 1)
                        .getChessColor() != getChessColor())) {
            list.add(new ChessboardPoint(x, y + 1));
        }

        if (isInBoard(x, y - 1)
                && !(game.getChess(x, y - 1) instanceof EmptySlotComponent)
                && (game.getChess(x, y - 1)
                        .getChessColor() != getChessColor())) {
            list.add(new ChessboardPoint(x, y - 1));
        }

        if ((getChessColor() == ChessColor.BLACK && getSource().getX() == 1)
                || (getChessColor() == ChessColor.WHITE
                        && getSource().getX() == 6)) {
            x = getSource().getX() + 2 * dx;
            y = getSource().getY() + dy;

            if (isInBoard(x, y)
                    && (game.getChess(x, y) instanceof EmptySlotComponent)) {
                list.add(new ChessboardPoint(x, y));
            }

        }

        return list;
    }

}