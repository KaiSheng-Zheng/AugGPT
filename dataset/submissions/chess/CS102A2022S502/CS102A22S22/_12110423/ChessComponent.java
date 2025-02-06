import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    private ChessComponent[][] chessComponents;

    void setChessComponents(ChessComponent[][] chessComponents){
        this.chessComponents = chessComponents;
    }

    public ChessComponent(){}
    public ChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor){
        this.source = chessboardPoint;
        this.chessColor = chessColor;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessboardPoint getSource() {
        return source;
    }
    public ChessColor getChessColor() {
        return chessColor;
    }

    public void SetChessColor(char name1){
        if (Character.isLowerCase(name1)){
            this.chessColor = ChessColor.WHITE;
        }else if (Character.isUpperCase(name1)){
            this.chessColor = ChessColor.BLACK;
        }else {
            this.chessColor = ChessColor.NONE;
        }
    }
}
