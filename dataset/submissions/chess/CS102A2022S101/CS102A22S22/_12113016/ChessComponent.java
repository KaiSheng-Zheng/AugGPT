import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private List<ChessboardPoint> whereCanMove = new ArrayList<>();
    private List<String> chessboard = new ArrayList<>();
    private ChessComponent[][] chesses = new ChessComponent[8][8];

    public ChessComponent[][] getChesses() {
        return chesses;
    }

    public void setChesses(ChessComponent[][] chesses) {
        this.chesses = chesses;
    }

    public List<String> getChessboard() {
        return chessboard;
    }

    public void setChessboard(List<String> chessboard) {
        this.chessboard = chessboard;
    }

    public List<ChessboardPoint> getWhereCanMove() {
        return whereCanMove;
    }

    public void setWhereCanMove(List<ChessboardPoint> whereCanMove) {
        this.whereCanMove = whereCanMove;
    }

    //should design
    public ChessComponent() {

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

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     *
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public void giveValueTo(ChessComponent target) {

    }

    ;


}
