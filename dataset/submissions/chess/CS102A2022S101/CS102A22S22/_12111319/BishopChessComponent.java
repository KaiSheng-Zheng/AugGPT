import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;
    public BishopChessComponent (char name,ChessColor chessColor,ChessComponent[][] chessComponents,ChessboardPoint source) {
        super(name,chessColor,chessComponents,source);
        this.name = name;
        this.source = source;
        this.chessColor = chessColor;
        this.chessComponents = chessComponents;
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> C = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (canMoveto(i,j)) {
                    C.add(new ChessboardPoint(i,j));
                }
            }
        }
        return C;
    }

    @Override
    public String toString() {
        if (chessColor == ChessColor.WHITE) {
            return "b";
        } else {
            return "B";
        }
    }

    public ChessColor getChessColor() {
        return chessColor;
    }
    public ChessComponent getChess(int X,int Y) {
        return chessComponents[X][Y];
    }

    public boolean canMoveto(int X, int Y) {
        int x = Math.abs(source.getX() - X);
        int y = Math.abs(source.getY() - Y);
        if (getChess(source.getX(), source.getY()).getChessColor() == getChess(X, Y).getChessColor()) {
            return false;
        } else if (x == y) {
            if ((x == 1)&&(y == 1)) {
                return true;
            } else if ((Math.max(X, source.getX()) == X) && (Math.max(Y, source.getY()) == Y)) {
                int row = source.getX() + 1;
                for (int col = Math.min(source.getY(), Y) + 1; col < Math.max(source.getY(), Y); col++) {
                    if (!(getChess(row, col) instanceof EmptySlotComponent)) {
                        return false;
                    }
                    row++;
                }
                return true;
            } else if ((Math.max(X, source.getX()) == source.getX()) && (Math.max(Y, source.getY()) == Y)) {
                int row = source.getX() - 1;
                for (int col = Math.min(source.getY(), Y) + 1; col < Math.max(source.getY(), Y); col++) {
                    if (!(getChess(row, col) instanceof EmptySlotComponent)) {
                        return false;
                    }
                    row--;
                }
                return true;
            } else if ((Math.max(X, source.getX()) == X) && (Math.max(Y, source.getY()) == source.getY())) {
                int row = X - 1;
                for (int col = Math.min(source.getY(), Y) + 1; col < Math.max(source.getY(), Y); col++) {
                    if (!(getChess(row, col) instanceof EmptySlotComponent)) {
                        return false;
                    }
                    row--;
                }
                return true;
            } else if ((Math.max(X, source.getX()) == source.getX()) && (Math.max(Y, source.getY()) == source.getY())) {
                int row = X + 1;
                for (int col = Math.min(source.getY(), Y) + 1; col < Math.max(source.getY(), Y); col++) {
                    if (!(getChess(row, col) instanceof EmptySlotComponent)) {
                        return false;
                    }
                    row++;
                }
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
