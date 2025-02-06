import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ConcreteChessGame concreteChessGame;

    //should design
    public ChessComponent(){}
    public ChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        this.name=name;
        this.chessColor=chessColor;
        this.source=source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public char getName() {
        return name;
    }

    protected void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    protected void setConcreteChessGame(ConcreteChessGame concreteChessGame) {
        this.concreteChessGame = concreteChessGame;
    }

    public ConcreteChessGame getConcreteChessGame() {
        return concreteChessGame;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setName(char name) {
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

}
