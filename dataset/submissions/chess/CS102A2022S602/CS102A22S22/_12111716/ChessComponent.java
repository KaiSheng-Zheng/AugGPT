import java.util.List;

public  abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    static ChessComponent[][] chessComponents=new ChessComponent[8][8];


    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char getName) {
        this.source=source;
        this.chessColor=chessColor;
        this.name=getName;
    }
    public ChessComponent(){}
    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        return String.valueOf(getName());
    }
    public ChessboardPoint getChessboardPoint() {
        return this.source;
    }

    public char getName() {
        return this.name;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
}
