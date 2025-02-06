import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;

    public ChessComponent(){}
    public ChessComponent(ChessboardPoint source,ChessColor chessColor,char name, ChessComponent[][] chessComponents){
        this.source=source;this.name=name;this.chessColor=chessColor;this.chessComponents=chessComponents;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

 public ChessComponent[][] getChessComponents(ChessComponent[][] chessComponents) {
        return chessComponents;
    }
    
    public ChessboardPoint getSource() {
        return source;
    }

}