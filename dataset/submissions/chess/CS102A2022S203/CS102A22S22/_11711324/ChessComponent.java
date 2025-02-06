import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    public ChessComponent[][] chessComponents;
    protected char name;

    public ChessComponent(){
        chessColor=ChessColor.NONE;
    }

    //should design
    public ChessComponent(ChessColor chessColor,ChessboardPoint source){
        this.chessColor=chessColor;
        this.source=source;
        this.chessComponents=null;
    }
    public void moveTo(ChessboardPoint newPoint){
        source=newPoint;
    }
    public ChessboardPoint getPoint(){
        return source;
    }
    public ChessColor getColor(){
        return chessColor;
    }
    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents=chessComponents;
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
