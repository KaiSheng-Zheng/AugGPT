import java.util.List;

public abstract class ChessComponent {

    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor;  // What's the color
    protected char name;
    protected ChessGame currentChessGame;
    protected static ChessComponent[][] chessboard;

    public ChessComponent(){}

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessGame currentChessGame){
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
        this.currentChessGame = currentChessGame;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {

        return String.valueOf(this.name);
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessColor getChessColor(){
        return this.chessColor;
    }

    public ChessboardPoint getSource(){
        return source;
    }

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }
}