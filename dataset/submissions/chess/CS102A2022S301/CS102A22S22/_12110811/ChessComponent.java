import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public ChessComponent[][] NowBoard=new ChessComponent[8][8];
    public ChessboardPoint getSource() {
        return source;
    }


    public ChessComponent[][] getNowBoard() {
        return NowBoard;
    }

    public void setNowBoard(ChessComponent[][] nowBoard) {
        NowBoard = nowBoard;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    //should design
    public ChessComponent(){

    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
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
