import java.util.List;

public abstract class ChessComponent {

    public ChessboardPoint getSource() {
        return source;
    }

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    protected ChessComponent[][] chessboard;

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    protected ChessboardPoint source; // Where the chess is

    public ChessColor getChessColor() {
        return chessColor;
    }

    private ChessColor chessColor; // What's the color
    protected char name; // What's the name

    public ChessComponent(){}

    public ChessComponent(ChessboardPoint source,ChessColor chessColor, char name){
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
