import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source ;
    private ChessColor chessColor ;
    private ChessComponent[][] chessComponents;
    protected char name ;

    public ChessComponent(){
    }

    public void setSource(int x,int y){
        ChessboardPoint chess = new ChessboardPoint(x,y) ;
        this.source = chess ;
    }
    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    private ChessComponent[][] getChessComponents(){
        return chessComponents;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}

