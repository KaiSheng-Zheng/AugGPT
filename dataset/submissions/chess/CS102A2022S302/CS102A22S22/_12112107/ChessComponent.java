import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    protected ChessColor chessColor;
    protected char name;
    public static ChessComponent[][] chessboard;
    protected ChessboardPoint chessboardPoint;


    public char getName() {
        return name;
    }
    public void setChessColor(ChessColor chessColor){
        this.chessColor = chessColor;
    }
    public ChessColor getChessColor() {
        return this.chessColor;
    }

    public static void setChessboard(ChessComponent[][] chessboard) {
        ChessComponent.chessboard = chessboard;
    }


    public void setChessboardPoint(ChessboardPoint chessboardPoint){
        this.chessboardPoint = chessboardPoint;
    }
    public void setName(char a){this.name=a;}
    public abstract List<ChessboardPoint> canMoveTo();

    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessboardPoint getChessboardPoint(){
        return this.chessboardPoint;
    }
}