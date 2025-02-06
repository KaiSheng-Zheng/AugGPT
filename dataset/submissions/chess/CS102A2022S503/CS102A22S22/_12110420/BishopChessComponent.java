import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

public class BishopChessComponent extends ChessComponent {
    protected char name;
    private ChessboardPoint source;
    private ChessColor chessColor;

    private ChessComponent[][] chess;

    public BishopChessComponent(ChessboardPoint source, char name, ChessComponent[][] chess) {
        this.source = source;
        this.chessColor = name <= 'z' && name >= 'a' ? ChessColor.WHITE : ChessColor.BLACK;
        this.name = name;
        this.chess = chess;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> res = new ArrayList<ChessboardPoint>();
        ChessboardPoint cp;
        int x = source.getX();
        int y = source.getY();
        for (int i = 1; i < 8; i++) {
            res.add(source.offset(i, i));
            res.add(source.offset(-i, -i));
            res.add(source.offset(-i, i));
            res.add(source.offset(i, -i));
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

    @Override
    public void moveTo(ChessboardPoint target) {
        source = target;
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
        if (x < x1 && y < y1) {
            for (int i = 1; i < (x1 - x); i++)
                if (chess[x + i][y + i].getSide() != ChessColor.NONE)
                    return false;
        } else if (x < x1 && y > y1) {
            for (int i = 1; i < (y - y1); i++)
                if (chess[x + i][y - i].getSide() != ChessColor.NONE)
                    return false;
        } else if (x > x1 && y < y1) {
            for (int i = 1; i < (x - x1); i++)
                if (chess[x - i][y + i].getSide() != ChessColor.NONE)
                    return false;
        } else if (x > x1 && y > y1) {
            for (int i = 1; i < (x - x1); i++)
                if (chess[x - i][y - i].getSide() != ChessColor.NONE)
                    return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
