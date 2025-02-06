import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard;
    private List<ChessboardPoint> canMoveTo;

    public ChessComponent() {
    }

    public ChessComponent(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    public String toString() {
        return String.valueOf(this.name);
    }

    public abstract List<ChessboardPoint> canMoveTo();

    public void KingChessComponent(ChessboardPoint source, ConcreteChessGame chess) {
    }

    public void QueenChessComponent(ChessboardPoint source, ConcreteChessGame chess) {
    }

    public void RookChessComponent(ChessboardPoint source, ConcreteChessGame chess) {

    }

    public void BishopChessComponent(ChessboardPoint source, ConcreteChessGame chess) {

    }

    public void KnightChessComponent(ChessboardPoint source, ConcreteChessGame chess) {

    }

    public void PawnChessComponent(ChessboardPoint source, ConcreteChessGame chess) {

    }

    public void EmptyChessComponent(ChessboardPoint source, ConcreteChessGame chess) {

    }

    public void setChessboard(ChessComponent[][] chessComponents) {

    }

    protected ChessColor getChessColor() {
        return chessColor;
    }

    protected ChessboardPoint getSource() {
        return source;
    }

    protected List<ChessboardPoint> ComparecanMoveTo(List<ChessboardPoint> canMoveTo) {
        List<ChessboardPoint> comparecanMoveTo = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < canMoveTo.size(); k++) {
                    if (i == canMoveTo.get(k).getX() && j == canMoveTo.get(k).getY()) {
                        comparecanMoveTo.add(canMoveTo.get(k));
                    }
                }
            }
        }
        return comparecanMoveTo;
    }
}
