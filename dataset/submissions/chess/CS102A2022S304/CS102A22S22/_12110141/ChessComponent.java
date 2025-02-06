import java.util.List;

public abstract class ChessComponent {  // represent all the chess components on the chessboard
    //should design
    private ChessboardPoint source;  //Where the chess is
    protected ChessComponent[][] chessboard;
    private ChessColor chessColor;  // What's the color
    protected char name;  // What's the name


    public ChessComponent() {
    }


    public ChessComponent(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }


    public ChessColor getChessColor() {
        return this.chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    //should design

    public void setSource(ChessboardPoint source) {
        this.source = source;
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

    protected ChessColor chessColor() {
        ChessColor chessColor;
        if (this.name >= 'A' && this.name <= 'Z') {
            chessColor = ChessColor.BLACK;
        }
       else if (this.name >= 'a' && this.name <= 'z') {
            chessColor = ChessColor.WHITE;
        }
       else {
            chessColor = ChessColor.NONE;

        }
        return chessColor;
    }
}
