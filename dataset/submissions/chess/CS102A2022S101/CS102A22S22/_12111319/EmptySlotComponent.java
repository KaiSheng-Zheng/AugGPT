import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    protected char name;
    private ChessboardPoint source;
    protected ChessColor chessColor;
    private ChessComponent[][] chessComponents;
    public EmptySlotComponent (char name,ChessColor chessColor,ChessComponent[][] chessComponents,ChessboardPoint source) {
        super(name,chessColor,chessComponents,source);
        this.name = name;
        this.source = source;
        this.chessColor = chessColor;
        this.chessComponents = chessComponents;
    }
    public String toString() {
        return "_";
    }
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> C = new ArrayList<>();
        return C;
    }

    public boolean canMoveto(int X, int Y) {
        return false;
    }
    public ChessColor getChessColor() {
        return chessColor;
    }
    public ChessComponent getChess(int X,int Y) {
        return chessComponents[X][Y];
    }

}