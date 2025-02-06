import java.util.List;

public abstract class ChessComponent {
    //should design
    protected ChessComponent[][] chessComponents;
    protected char[] Black = new char[]{'K', 'Q', 'R', 'B', 'N', 'P'};
    protected char[] White = new char[]{'k', 'q', 'r', 'b', 'n', 'p'};
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public ChessComponent(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
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

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    //should design
    public ChessComponent() {
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public boolean canEat(ChessComponent c1, ChessComponent c2) {
        return c1.getChessColor() != c2.getChessColor();
    }

    /**
     * should design
     *
     * @return
     */
    @Override
    public String toString() {
        return null;
    }

}