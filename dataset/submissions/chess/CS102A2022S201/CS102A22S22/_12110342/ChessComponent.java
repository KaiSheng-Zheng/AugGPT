import java.util.List;



public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    ChessComponent[][] chessComponents;

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public char getName() {
        return name;
    }

    protected char name;

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public void setName(char name) {
        this.name = name;
    }

    public ChessComponent(){}
    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {    return String.valueOf(this.name);}
}
