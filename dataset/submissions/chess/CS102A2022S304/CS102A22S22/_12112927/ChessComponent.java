import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public ChessComponent() {
    }

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.name = name;
        this.chessColor = chessColor;
        this.source = source;
    }

    public boolean EmptyJudge(ChessComponent chessComponent) {
        return chessComponent instanceof EmptySlotComponent;
    }

    public boolean DifferentColorJudge(ChessColor chessColor, ChessComponent chessComponent) {
        return !(chessColor == chessComponent.getChessColor());
    }


    public abstract List<ChessboardPoint> canMoveTo();


    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }


    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
