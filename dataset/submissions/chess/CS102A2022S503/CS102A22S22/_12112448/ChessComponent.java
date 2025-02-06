import java.util.List;

public abstract class  ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent [][]chessboard;
    public ChessComponent(){}
    public abstract List<ChessboardPoint> canMoveTo();

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setName(char name) {
        this.name = name;
    }

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
