import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private int id;
    protected static ChessComponent[][] chessboard;

    //should design
    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
        this.id=id;

    }

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name, int id) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
        this.id = id;

    }
    public void setChessBoard(ChessComponent[][] board){
        this.chessboard = board;
        this.chessboard[source.getX()][source.getY()]=this;
    }

    public ChessComponent() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ChessComponent[][] getChessboard() {
        return chessboard;
    }

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
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
//    public abstract boolean canEat(int x,int y);

}