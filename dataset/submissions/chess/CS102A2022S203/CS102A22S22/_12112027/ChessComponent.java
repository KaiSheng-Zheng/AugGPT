import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;

    private ConcreteChessGame belong;
    protected char name;

    //should design
    public ChessComponent(){
    }

    public ChessComponent(ChessboardPoint point, ChessColor chessColor, ConcreteChessGame concreteChessGame){
        source = point;
        this.chessColor = chessColor;
        this.belong = concreteChessGame;
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

    public char getName() {
        return name;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }
}
