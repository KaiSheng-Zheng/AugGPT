import java.util.List;

public abstract class ChessComponent {
    // should not define these field again in child classes
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    public ChessComponent getChessComponents(int x, int y) {
        return chessComponents[x][y];
    }
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }
    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
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
    //should design
    public ChessComponent(){}
    // should design
    public abstract List<ChessboardPoint> canMoveTo();
    /**
     * should design
     */
    @Override
    public String toString() {
        return String.valueOf(getName());
    }

}
