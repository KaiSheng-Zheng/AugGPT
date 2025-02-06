import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;



    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }
    public ChessComponent(){}
    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public char getName() {
        return name;
    }

public  void setSource(ChessboardPoint p2){
     this.source=p2;
}

    public abstract List<ChessboardPoint> canMoveTo();

    public ChessComponent[][] chessboard=new ChessComponent[8][8];


    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
