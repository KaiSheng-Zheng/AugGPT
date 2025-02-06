import java.util.List;

public abstract class ChessComponent {
    //should design
    protected ChessComponent[][] array;
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public ChessComponent(ChessColor chessColor, char name,int x ,int y,ChessComponent[][] chessComponents) {
        this.chessColor = chessColor;
        this.name = name;
        source =new ChessboardPoint(x,y);
        array=chessComponents;
    }

    //should design
    public ChessComponent(){}

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessboardPoint getSource() {
        return source;
    }


}
