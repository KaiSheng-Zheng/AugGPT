import java.util.List;

public abstract class ChessComponent {
    ChessboardPoint source; // Where the chess is
    ChessColor chessColor; // What's the color
    protected char name; // What's the name
    protected ChessComponent[][] chessboard = new  ChessComponent[8][8];

    public ChessComponent(ChessColor chessColor,ChessboardPoint source){
        this.source=source;
        this.chessColor=chessColor;
    }

    public ChessComponent(){
    }

    public abstract List<ChessboardPoint> canMoveTo();







    public String toString() {
        return String.valueOf(this.name);
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void loadCurrentChessboard(ChessComponent[][] chessboard){
        this.chessboard=chessboard;
    }
}
