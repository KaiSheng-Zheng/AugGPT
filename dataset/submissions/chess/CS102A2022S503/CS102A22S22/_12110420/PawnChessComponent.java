import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class PawnChessComponent extends ChessComponent {
    protected char name;
    private ChessboardPoint source;
    private ChessColor chessColor;
    private ChessComponent[][] chess;

    public PawnChessComponent(ChessboardPoint source, char name, ChessComponent[][] chess) {
        this.source = source;
        this.chessColor = name <= 'z' && name >= 'a' ? ChessColor.WHITE : ChessColor.BLACK;
        this.name = name;
        this.chess = chess;

    }

    public boolean isMoved() {
        boolean isMoved = true;
        if (chessColor == ChessColor.WHITE && source.getX() == 6) {
            isMoved = false;

        } else if (chessColor == ChessColor.BLACK && source.getX() == 1) {
            isMoved = false;
        }
        return isMoved;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> res = new ArrayList<ChessboardPoint>();
        ChessboardPoint cp;
        int x = source.getX();
        int y = source.getY();
        if (!isMoved() && chessColor == ChessColor.BLACK) {
            res.add(source.offset(1, 0));
            res.add(source.offset(2, 0));
            res.add(source.offset(1, 1));
            res.add(source.offset(1, -1));
        } else if (!isMoved() && chessColor == ChessColor.WHITE) {
            res.add(source.offset(-1, 0));
            res.add(source.offset(-2, 0));
            res.add(source.offset(-1, 1));
            res.add(source.offset(-1, -1));
        } else if (chessColor == ChessColor.WHITE) {
            res.add(source.offset(-1, 0));
            res.add(source.offset(-1, 1));
            res.add(source.offset(-1, -1));
        } else {
            res.add(source.offset(1, 0));
            res.add(source.offset(1, 1));
            res.add(source.offset(1, -1));
        }
        res.removeIf(Objects::isNull);
        Iterator<ChessboardPoint> iterator = res.iterator();
        while (iterator.hasNext()) {
            cp = iterator.next();
            if (!canMove(cp)) {
                iterator.remove();
            }
        }
        return res;
    }

    public boolean canMove(ChessboardPoint cp) {
        int x = cp.getX();
        int y = cp.getY();
        int x1 = source.getX();
        int y1 = source.getY();
        if (y != y1) {
            if (chess[x][y].getSide() == ChessColor.NONE) {
                return false;
            } else if (chess[x][y].getSide() != getSide()) {
                return true;
            }
        } else if (isEmpty(x, y, x1, y1, chess)) {
            return true;
        }
        return false;
    }

    public boolean isEmpty(int x, int y, int x1, int y1, ChessComponent[][] chess) {
        if (chess[x][y].getSide() == ChessColor.NONE) {
            if (x == x1 + 2) {
                if (chess[x1 + 1][y].getSide() == ChessColor.NONE) {
                    return true;
                }
                return false;
            } else if (x == x1 - 2) {
                if (chess[x1 - 1][y].getSide() == ChessColor.NONE) {
                    return true;
                }
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    public ChessColor getSide() {
        return chessColor;
    }


    public ChessboardPoint getSource() {
        return source;
    }

    @Override
    public void moveTo(ChessboardPoint target) {
        source = target;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
