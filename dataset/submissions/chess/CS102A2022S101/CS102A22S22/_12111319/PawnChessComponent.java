import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;
    public PawnChessComponent (char name,ChessColor chessColor,ChessComponent[][] chessComponents,ChessboardPoint source) {
        super(name,chessColor,chessComponents,source);
        this.name = name;
        this.source = source;
        this.chessColor = chessColor;
        this.chessComponents = chessComponents;
    }

    public ChessComponent getChess(int X,int Y) {
        return chessComponents[X][Y];
    }

    public ChessColor getChessColor() {
        return chessColor;
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

    public String toString() {
        if (chessColor == ChessColor.WHITE) {
            return "p";
        } else {
            return "P";
        }
    }

    public boolean canMoveto(int X, int Y) {
        int x = X-source.getX();
        int y = Math.abs(Y-source.getY());
        if (y == 0) {
            if (chessColor == ChessColor.BLACK) {
                for (int i = source.getX()+1;i <= X;i++) {
                    if (!(getChess(i,source.getY()) instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
                if ((source.getX() == 1) && (x == 2)) {
                    return true;
                } else if (x == 1) {
                    return true;
                } else {
                    return false;
                }
            } else {
                for (int i = source.getX()-1;i >= X;i--) {
                    if (!(getChess(i,source.getY()) instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
                if ((source.getX() == 6) && (x == -2)) {
                    return true;
                } else if (x == -1) {
                    return true;
                } else {
                    return false;
                }
            }
        } else if ((y == 1)&&(Math.abs(x) == 1)) {
            if ((chessColor == ChessColor.BLACK)&&(x > 0)) {
                if (getChess(X, Y).getChessColor() == ChessColor.WHITE) {
                    return true;
                } else {
                    return false;
                }
            } else if ((getChessColor() == ChessColor.WHITE)&&(x < 0)){
                if (getChess(X, Y).getChessColor() == ChessColor.BLACK) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
