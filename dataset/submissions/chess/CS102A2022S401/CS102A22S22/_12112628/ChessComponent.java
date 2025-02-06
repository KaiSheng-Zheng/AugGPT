import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard;

    public ChessComponent() {}

    public ChessComponent(ChessboardPoint source, char name, ChessComponent[][] chessboard) {
        this.source = source;
        this.name = name;
        this.chessboard = chessboard;
        if (Character.isUpperCase(name))
            chessColor = ChessColor.BLACK;
        else if (Character.isLowerCase(name))
            chessColor = ChessColor.WHITE;
        else
            chessColor = ChessColor.NONE;

    }
    public abstract List<ChessboardPoint> canMoveTo();

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public char getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }

    public void setSource(ChessboardPoint newSource) {
        this.source = newSource;
    }
}
