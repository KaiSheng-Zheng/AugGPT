import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected  char name;
    protected ChessComponent[][] chessComponents;

    public ChessComponent() {

    }


    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString(){
        return String.valueOf(this.name);
    }
    public ChessboardPoint getChessboardPoint(){
        return source;
    }
    public ChessComponent[][] getChessComponents(){
        return chessComponents;
    }
    public ChessColor getChessColor(){
        return chessColor;
    }
    public void setSource(ChessboardPoint chessboardPoint){
        source = chessboardPoint;
    }
    public void setChessColor(ChessColor chessColor){
        this.chessColor = chessColor;
    }
    public void setChessComponents(ChessComponent[][] chessComponents){
        this.chessComponents = chessComponents;
    }




}
