import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessComponent[][] board, ChessboardPoint point, ChessColor side) {
        super(board);
        setSource(point);
        setChessColor(side);
        name = side == ChessColor.BLACK? 'Q' : 'q';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> pattern = new ArrayList<>();

        
        ChessboardPoint pos = getSource();

        while (true) {
            pos = pos.offset(0, 1);
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
            pos = pos.offset(0, -1);
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
            pos = pos.offset(-1, 0);
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
            pos = pos.offset(1, 0);
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