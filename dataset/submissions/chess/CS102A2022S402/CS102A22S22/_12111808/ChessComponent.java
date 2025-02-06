import java.util.List;

public abstract class ChessComponent {
     ChessboardPoint source; // Where the chess is
     ChessColor chessColor;  // What's the color
    protected char name;			// What's the name
    protected ChessComponent[][] chessboard=new ChessComponent[8][8];

    public  ChessComponent(){}

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    public ChessComponent(ChessboardPoint source, ChessColor chessColor) {
        this.source = source;
        this.chessColor = chessColor;
    }

    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
