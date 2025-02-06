import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public static ChessComponent[][] chessComponents;


    //should design
    public ChessComponent(){}

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
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
    public ChessboardPoint getChessboardPoint() {
        return source;
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
    public static void setChessComponents (ChessComponent[][] chessComponents) {
        chessComponents = chessComponents;
    }
    public static ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public ChessColor getColor() {
        return null;}
    public void setChessboard(ChessComponent[][] chessComponents) {
        this.chessComponents =chessComponents;
    }
    protected ConcreteChessGame itsConcreteGame;
    public void setItsConcreteGame(ConcreteChessGame ccg){
        itsConcreteGame=ccg;
    }

}
