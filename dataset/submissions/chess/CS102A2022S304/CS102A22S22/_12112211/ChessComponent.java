import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;



    protected ChessComponent[][] chessBoard;
    //should design
    public ChessComponent(){

    }
    void loadCurrentChessboard(ChessComponent[][] chessBoard){
        this.chessBoard=chessBoard;
    }
    public void setChessBoard(ChessComponent[][] chessBoard) {
        this.chessBoard = chessBoard;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessboardPoint getSource() {
        return source;
    }


    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setName(char name) {
        this.name = name;
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
