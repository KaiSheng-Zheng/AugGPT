import java.util.List;
import java.util.Locale;

public abstract class ChessComponent {
    protected ChessboardPoint source; // Where the chess is
    protected ChessColor chessColor;  // What's the color
    protected char name;

    public ChessComponent(){}

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        if(chessColor == ChessColor.BLACK)
            return String.valueOf(this.name);
        else
            return String.valueOf(this.name).toLowerCase(Locale.ROOT);
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public char getName() {
        return name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }
}
