import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;
    public ChessComponent(){
//        this.source = source;
//        this.chessColor = chessColor;
    }
    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
    public void setSource(ChessboardPoint source){
        this.source = source;
    }
    public void setChessColor(ChessColor chessColor){
        this.chessColor = chessColor;
    }
    public ChessboardPoint getSource(){
        return source;
    }
    public ChessColor getChessColor(){
        return chessColor;
    }
    public void updateBoard(ChessComponent[][] newBoard){
        this.chessComponents = newBoard;
    }
    public char getName(){
        return name;
    }
}
