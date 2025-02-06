import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source=new ChessboardPoint(0,0);
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] Chessboard=new ChessComponent[8][8];

//    public ChessComponent(ChessComponent[][] Chessboard) {this.Chessboard=Chessboard;}


    public void setChessboard(ChessComponent[][] chessboard) {
        Chessboard = chessboard;
    }

    public void setName(char name) {
        this.name = name;
    }

    public void setSource(int x, int y)
    {
        ChessboardPoint output=new ChessboardPoint(x,y);
        this.source=output;
    }

    public ChessboardPoint getSource() {return source;}

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessColor getChessColor() {return chessColor;}

    //should design
    public ChessComponent(){
//        source=new ChessboardPoint(0,0);
//        chessColor=ChessColor.WHITE;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}