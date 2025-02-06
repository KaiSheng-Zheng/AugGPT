import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ConcreteChessGame currentChessboard;

    public ChessboardPoint getSource() {
        return source;
    }
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }
    public ChessComponent() {
    }

    public abstract List<ChessboardPoint> canMoveTo();

    public String toString(){
        return String.valueOf(name);
    }
}