import java.util.List;

public abstract class ChessComponent {
    //should design
    protected ChessboardPoint source;
    protected ChessColor chessColor;
    protected char name;

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    //should design
    public ChessComponent(){

    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    ;

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

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setName(char name) {
        this.name = name;
    }


}
