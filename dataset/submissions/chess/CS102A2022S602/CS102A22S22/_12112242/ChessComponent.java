import java.util.List;
public abstract class ChessComponent {
    protected ChessboardPoint source;
    protected ChessColor chessColor;
    protected char name;
    protected ChessComponent[][]chessComponents;
    public ChessComponent(){}
    public abstract List<ChessboardPoint>canMoveTo();

    public String toString(){
        return String.valueOf(this.name);
    }

    public char getName() {
        return name;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setName(char name) {
        this.name = name;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
}
