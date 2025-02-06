import java.util.List;

public abstract class ChessComponent {
    public ChessboardPoint getSource() {
        return source;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    protected ChessComponent[][] chessComponents;
    private ChessboardPoint source;// Where the chess is
    private ChessColor chessColor=ChessColor.WHITE; // What's the color
    protected char name; // What's the name

    public ChessComponent(){}
    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
    public void setChessColor(ChessColor chessColor) {
        this.chessColor=chessColor;
    }
    public ChessColor getChessColor() {
        return chessColor;
    }
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
}