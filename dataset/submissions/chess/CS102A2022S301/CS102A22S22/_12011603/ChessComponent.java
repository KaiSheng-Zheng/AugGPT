import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected ChessComponent [][]array;
    protected char name;
    public void setChessColor(ChessColor chessColor){
        this.chessColor = chessColor;
    }
    public ChessComponent(ChessColor chessColor, ChessboardPoint source){
        this.chessColor = chessColor;
        this.source = source;
    }
    public ChessboardPoint getSource(){
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }
    public ChessComponent [][]getArray(){
        return array;
    }

    public void setArray(ChessComponent[][] array) {
        this.array = array;
    }

    public ChessComponent(){

    }
    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
