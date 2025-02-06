import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public ChessComponent[][] chessComponents;
    public RookChessComponent (char name,ChessColor chessColor,ChessComponent[][] chessComponents,ChessboardPoint source) {
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

    public String toString() {
        if (chessColor == ChessColor.WHITE) {
            return "r";
        } else {
            return "R";
        }
    }
    public ChessColor getChessColor() {
        return chessColor;
    }
    public ChessComponent getChess(int X,int Y) {
        return chessComponents[X][Y];
    }
    public boolean canMoveto(int X, int Y) {
        if ((source.getX() == X)&&(source.getY() == Y)) {
            return false;
        } else if (getChess(source.getX(),source.getY()).getChessColor() == getChess(X,Y).getChessColor()) {
            return false;
        } else if (source.getX() == X) {
            int row = source.getX();
            for (int col = Math.min(source.getY(), Y) + 1; col < Math.max(source.getY(), Y); col++) {
                if (!(getChess(row,col) instanceof EmptySlotComponent)) {
                    return false;
                }
            }
            return true;
        } else if (source.getY() == Y) {
            int col = source.getY();
            for (int row = Math.min(source.getX(), X) + 1; row < Math.max(source.getX(), X); row++) {
                if (!(getChess(row,col) instanceof EmptySlotComponent)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
