import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    private ConcreteChessGame concreteChessGame;

    //should design
    public ChessComponent(){}

    public ChessComponent(ChessColor chessColor, ChessboardPoint chessboardPoint,char name,ConcreteChessGame chessGame){
        this.chessColor = chessColor;
        this.source = chessboardPoint;
        this.name = name;
        this.concreteChessGame = chessGame;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ConcreteChessGame getConcreteChessGame() {
        return concreteChessGame;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public char getName() {
        return name;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(name);
    }

}
