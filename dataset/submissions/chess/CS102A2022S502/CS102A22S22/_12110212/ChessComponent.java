import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    ChessComponent[][] chessComponents = new ChessComponent[8][8];

    public void setName(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }

    public ChessComponent() {
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    public String toString() {
        return String.valueOf(this.name);
    }

    public void setChessboard(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }
}

