import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source = new ChessboardPoint(0,0);
    private ChessColor chessColor ;
    protected char name;
    protected ChessComponent[][] chessComponents;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessColor getChessColor() {
        return this.chessColor;
    }
    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessboardPoint getSource() {
        return this.source;
    }
    public void setSource(int x, int y) {
        this.source.setX(x);
        this.source.setY(y);
    }

    public void setName(char name) {
        this.name = name;
    }
    public char getName() {
        return name;
    }

    //---------------------
    //should design
    public  ChessComponent(){}

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(getName());
    }
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }


}
