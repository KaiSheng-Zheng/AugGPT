import java.util.List;

public abstract class ChessComponent {

    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color
    protected char name; // What's the name

    protected static ChessComponent[][] chessboard = new ChessComponent[8][8];

    public ChessComponent() {
    }


    public ChessComponent(char name, int x, int y) {
        // designate name
        this.name = name;
        // check color
        if (name == '_') {
            this.chessColor = ChessColor.NONE;
        } else if (Character.isUpperCase(name)) {
            this.chessColor = ChessColor.BLACK;
        } else {
            this.chessColor = ChessColor.WHITE;
        }
        source = new ChessboardPoint(x, y);
        chessboard[x][y] = this;
    }

    public static ChessComponent[][] getChessboard() {
        return chessboard;
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

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public abstract List<ChessboardPoint> canMoveTo();
    // be careful when using the coordinate
    // King, Knight and Pawn are limited moving thus can be enumerated,
    // while Queen, Bishop and Rook should carefully design codes to interrupt the loop

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }


}