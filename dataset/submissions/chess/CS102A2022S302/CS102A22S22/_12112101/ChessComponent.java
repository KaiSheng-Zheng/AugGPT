import java.util.List;

public abstract class ChessComponent {
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    protected ChessboardPoint source; // Where the chess is

    public ChessColor getChessColor() {
        return chessColor;
    }

    protected ChessColor chessColor; // What's the color
    protected char name; // What's the name

    public static void setChessboard(ChessComponent[][] chessboard) {
        ChessComponent.chessboard = chessboard;
    }

    public static ChessComponent[][] chessboard;

    public static ChessColor Color;

    public static void setColor(ChessColor color) {
        Color = color;
    }

    public char getName() {
        return name;
    }

    public ChessComponent(){

    }

    public abstract List<ChessboardPoint> canMoveTo();


    public String toString() {
        return String.valueOf(this.name);
    }

    public void setName(char name) {
        this.name = name;
    }

    public ChessboardPoint getSource() {
        return source;
    }
}

