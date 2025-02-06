import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessComponent[][] board, ChessboardPoint point, ChessColor side) {
        super(board);
        setSource(point);
        setChessColor(side);
        name = side == ChessColor.BLACK? 'B' : 'b';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> pattern = new ArrayList<>();

        
        ChessboardPoint pos = getSource();

        while (true) {
            pos = pos.offset(1, -1);
            if (!canMoveToBasic(pos)) {
                break;
            }
            pattern.add(pos);
            if (!(board[pos.getX()][pos.getY()] instanceof EmptySlotComponent)) {
                break;
            }
        }

        
        pos = getSource();

        while (true) {
            pos = pos.offset(-1, 1);
            if (!canMoveToBasic(pos)) {
                break;
            }
            pattern.add(pos);
            if (!(board[pos.getX()][pos.getY()] instanceof EmptySlotComponent)) {
                break;
            }
        }

        
        pos = getSource();

        while (true) {
            pos = pos.offset(1, 1);
            if (!canMoveToBasic(pos)) {
                break;
            }
            pattern.add(pos);
            if (!(board[pos.getX()][pos.getY()] instanceof EmptySlotComponent)) {
                break;
            }
        }

        
        pos = getSource();

        while (true) {
            pos = pos.offset(-1, -1);
            if (!canMoveToBasic(pos)) {
                break;
            }
            pattern.add(pos);
            if (!(board[pos.getX()][pos.getY()] instanceof EmptySlotComponent)) {
                break;
            }
        }

        return pattern;
    }
}