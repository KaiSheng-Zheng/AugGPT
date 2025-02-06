import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {

    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected List<String> chessboard= new ArrayList<>();

    public ChessComponent(List<String> chessboard) {
        this.chessboard = chessboard;
    }

    public void setChessboard(List<String> chessboard) {
        this.chessboard = chessboard;
    }

    protected ChessComponent[][] chessBoard = new ChessComponent[8][8];

    public ChessComponent(){
    }

    public ChessComponent(ChessboardPoint source, ChessColor chessColor) {
        this.source = source;
        this.chessColor = chessColor;
    }

    public ChessComponent(ChessComponent[][] chessComponents) {
        this.chessBoard = chessComponents;

    }

    public void setChessBoard(ChessComponent[][] chessBoard) {
        this.chessBoard = chessBoard;
    }

    public abstract List<ChessboardPoint> canMoveTo();


    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }



}