import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    //should design
    public ChessComponent(){

    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();
    public void setChessColor(ChessColor c){
        chessColor = c;
    }

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

