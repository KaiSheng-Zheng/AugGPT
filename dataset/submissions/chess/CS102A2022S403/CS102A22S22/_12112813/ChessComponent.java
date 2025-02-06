import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;//where the chess is
    private ChessColor chessColor;//what's the color
    protected char name;
    protected ConcreteChessGame chessGame;

    public void setName(char name) {
        this.name = name;
    }
    public void setChessGame(ConcreteChessGame chessGame){
        this.chessGame=chessGame;
    }
    public ChessboardPoint getChessboardPoint(){
        return source;
    }
    public ChessColor getChessColor(){
        return chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
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
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
