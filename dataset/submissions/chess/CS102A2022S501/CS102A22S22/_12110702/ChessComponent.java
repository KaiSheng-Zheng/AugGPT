import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source; // Where the chess is
   private ChessColor chessColor; // What's the color
    protected char name; // What's the name
    public ChessComponent(){}
    public abstract List<ChessboardPoint> canMoveTo();

    protected ChessComponent[][] chessBoard = new ChessComponent[8][8];

    public void setChessBoard(ChessComponent[][] chessBoard) {
        this.chessBoard = chessBoard;
    }

    public String toString() {
        return String.valueOf(this.name);
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

    public void setName(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }
}

