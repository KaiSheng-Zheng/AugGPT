import java.util.List;

public abstract class ChessComponent {

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    private ChessboardPoint source;

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    private ChessColor chessColor;

    public void setName(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }

    protected char name;

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
    }
}
