import java.util.List;

public abstract class ChessComponent  {

    private ChessboardPoint chessboardPoint;
    private ChessboardPoint source;
    protected ChessboardPoint destination;
    private ChessColor chessColor;
    protected char name;

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        setName(name);
        setChessColor(chessColor);
        setSource(source);
    }

    public ChessComponent(){};

    public char getName() {
        return name;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setName(char name) {
        this.name = name;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    public String toString(){
        return String.valueOf(this.name);
    }

    protected ChessboardPoint getChessboardPoint() {
        return this.source;
    }
}
