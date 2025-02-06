import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard;

    //should design
    public ChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ChessComponent[][] chessComponents){
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
        this.chessboard=chessComponents;
    }

    public ChessComponent(){
        ;
    }
    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public char getName() {
        return name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
