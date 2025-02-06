import java.util.List;

public abstract class ChessComponent {
    protected ChessboardPoint source;
    protected ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents;

    public ChessComponent() {
    }

    public ChessComponent(ChessboardPoint source, char name) {
        this.source = source;
        this.name = name;
    }

    public abstract List<ChessboardPoint> canMoveTo();
    //If no ChessboardPoint can be moved to, return a reference of empty List instead of null.

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public void setName(char name) {
        this.name = name;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setSource(int x, int y) {
        this.source = new ChessboardPoint(x, y);
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }


}