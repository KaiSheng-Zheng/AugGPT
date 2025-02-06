import java.util.*;

public class KingChessComponent extends ChessComponent {
    protected char name;
    private ChessboardPoint source;
    private ChessColor chessColor;
    private ChessComponent[][] chess;

    public KingChessComponent(ChessboardPoint source, char name, ChessComponent[][] chess) {
        this.source = source;
        this.chessColor = name <= 'z' && name >= 'a' ? ChessColor.WHITE : ChessColor.BLACK;
        this.name = name;
        this.chess = chess;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> res = new ArrayList<ChessboardPoint>();
        ChessboardPoint cp;
        int x = source.getX();
        int y = source.getY();
        res.add(source.offset(1, 1));
        res.add(source.offset(-1, -1));
        res.add(source.offset(1, 0));
        res.add(source.offset(0, 1));
        res.add(source.offset(-1, 1));
        res.add(source.offset(1, -1));
        res.add(source.offset(-1, 0));
        res.add(source.offset(0, -1));
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

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getSide() {
        return chessColor;
    }

    public boolean canMove(ChessboardPoint cp) {
        int x = cp.getX();
        int y = cp.getY();
        int x1 = source.getX();
        int y1 = source.getY();
        if ((chess[x1][y1].getSide() == ChessColor.WHITE && chess[x][y].getSide() != ChessColor.WHITE) || (chess[x1][y1].getSide() == ChessColor.BLACK && chess[x][y].getSide() != ChessColor.BLACK)) {
            if (isEmpty(x, y, x1, y1, chess)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty(int x, int y, int x1, int y1, ChessComponent[][] chess) {
        if (chess[x][y].getSide() == getSide()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    @Override
    public void moveTo(ChessboardPoint target) {
        source = target;
    }
}
