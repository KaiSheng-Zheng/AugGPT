import java.util.List;
public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ConcreteChessGame chessGame;
    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }

    public void setChessGame(ConcreteChessGame chessGame) {
        this.chessGame = chessGame;
    }

    public ChessComponent() {
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        if (chessColor==ChessColor.NONE){
            return "_";
        }
        return String.valueOf(this.name);
    }

}
