import java.util.List;

public abstract class ChessComponent {

    public ChessboardPoint source;
    public ChessColor chessColor;
    public char name;

    public ChessComponent() {
    }
    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }


    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }
    public abstract List<ChessboardPoint> canMoveTo();
    public char getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
