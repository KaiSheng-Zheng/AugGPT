import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;

    public ChessComponent(){}

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
        this.chessComponents = chessComponents;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setName(char name) {
        this.name = name;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents (ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }
}
