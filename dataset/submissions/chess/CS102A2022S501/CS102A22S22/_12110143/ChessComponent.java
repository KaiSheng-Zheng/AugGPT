import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public ChessComponent(){}
    public ChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public abstract List<ChessboardPoint> canMoveTo();
    public ChessboardPoint GetChessboardPoint(){
        return this.source;
    }

    public void SetChessboardPoint(ChessboardPoint source){
         this.source=source;
    }
    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(name);
    }
}

