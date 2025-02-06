import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public ChessComponent[][] chessComponents;

    public KingChessComponent (char name,ChessColor chessColor,ChessComponent[][] chessComponents,ChessboardPoint source) {
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
            return "k";
        } else {
            return "K";
        }
    }

    public ChessColor getChessColor() {
        return chessColor;
    }
    public ChessComponent getChess(int X,int Y) {
        return chessComponents[X][Y];
    }

    public boolean canMoveto(int X,int Y) {
        int x = Math.abs(source.getX()-X);
        int y = Math.abs(source.getY()-Y);
        if ((x <= 1)&&(y <= 1)&&(getChess(X,Y).getChessColor() != getChess(source.getX(),source.getY()).getChessColor())) {
            return true;
        } else {
            return false;
        }
    }
}
