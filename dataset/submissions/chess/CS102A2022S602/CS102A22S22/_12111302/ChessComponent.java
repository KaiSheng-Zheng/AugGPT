import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;


    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name)
    {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }
    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents)
    {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
        this.chessComponents=chessComponents;
    }

    public ChessComponent() {

    }
    public ChessboardPoint getSource(){
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public char getName() {
        return name;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
}
