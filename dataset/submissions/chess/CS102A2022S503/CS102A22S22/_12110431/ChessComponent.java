import java.util.List;

public abstract class ChessComponent {

    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    ChessComponent[][] chessComponents;

    public ChessComponent(){}

    public ChessComponent(ChessboardPoint source,ChessColor color,char name,ChessComponent[][] chessComponents){
        this.name=name;
        this.source=source;
        this.chessColor=color;
        this.chessComponents=chessComponents;
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

    public abstract List<ChessboardPoint> canMoveTo();

    public String toString() {
        return String.valueOf(this.name);
    }
}
