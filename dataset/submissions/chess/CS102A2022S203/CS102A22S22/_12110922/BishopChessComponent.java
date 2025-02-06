import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 */
public class BishopChessComponent extends ChessComponent {

    // creates a new BishopChessComponent
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor, 'B');
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();

        int[][] offsets = { { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

        for (int[] is : offsets) {
            int dx = is[0];
            int dy = is[1];

            for (int i = 1; i < 8; i++) {
                int x = getSource().getX() + i * dx;
                int y = getSource().getY() + i * dy;
 
                if (isInBoard(x, y)) {
                    if ((game.getChess(x, y) instanceof EmptySlotComponent)) {
                        list.add(new ChessboardPoint(x, y));
                    } else if (game.getChess(x, y)
                            .getChessColor() != getChessColor()) {
                        list.add(new ChessboardPoint(x, y));
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        Collections.sort(list);
        return list;
    }

}