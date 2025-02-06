import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents;
    public ChessComponent(){}
    //maybe more constructor should be defined
    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    public abstract List<ChessboardPoint> canMoveTo();


    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
}
