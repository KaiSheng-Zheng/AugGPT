import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public ChessComponent[][] chessComponents;

    public KnightChessComponent (char name,ChessColor chessColor,ChessComponent[][] chessComponents,ChessboardPoint source) {
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
            return "n";
        } else {
            return "N";
        }
    }
    public ChessColor getChessColor() {
        return chessColor;
    }
    public ChessComponent getChess(int X,int Y) {
        return chessComponents[X][Y];
    }


     public boolean canMoveto(int X,int Y) {
        if ((Math.abs(source.getX() - X) == 1) && (Math.abs(source.getY() - Y) == 2) && (chessComponents[X][Y].getChessColor() != getChess(source.getX(), source.getY()).getChessColor())) {
            return true;
        }
        if ((Math.abs(source.getX() - X) == 2) && (Math.abs(source.getY() - Y) == 1) && (chessComponents[X][Y].getChessColor() != getChess(source.getX(), source.getY()).getChessColor())) {
            return true;
        }
        return false;
    }
}
