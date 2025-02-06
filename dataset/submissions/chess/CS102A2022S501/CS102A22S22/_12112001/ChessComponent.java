import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public ChessComponent(ChessboardPoint chessboardPoint,ChessColor chesscolor,char name){
        this.name=name;
        this.source=chessboardPoint;
        this.chessColor=chesscolor;
    }

    public ChessComponent() {
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public abstract List<ChessboardPoint> canMoveTo();


    @Override
    public String toString(){
        return String.valueOf(this.name);
    }


    public ChessboardPoint getChessboardPoint() {
        return source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
}
