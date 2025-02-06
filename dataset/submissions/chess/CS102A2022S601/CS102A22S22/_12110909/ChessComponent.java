import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard = new ChessComponent[8][8];

    public ChessComponent(){}

    public ChessComponent(ChessboardPoint source, ChessColor chessColor) {
        this.source = source;
        this.chessColor = chessColor;
    }

    public ChessComponent[][] getChessboard() {
        return chessboard;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void loadChessboard(ChessComponent[][] chessComponents){
        chessboard = chessComponents;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
}
