import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source; // position of the chess
    private ChessColor chessColor; // color of the chess
    protected char name; // name of the chess
    protected ChessComponent[][] chessboard;

    // Constructor
    public ChessComponent(){
        ChessboardPoint source = new ChessboardPoint();
        this.setSource(source);
        this.setChessColor(ChessColor.NONE);
        ChessComponent[][] chessComponents = new ChessComponent[8][8];
        this.setChessboard(chessComponents); // construct a chessComponents of 8*8
    }

    // Setter & Getter
    public ChessboardPoint getSource() {
        return source;
    }
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
    // additional
    public void setSource(int x, int y){
        this.source = new ChessboardPoint(x, y);
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

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }
    public ChessComponent[][] getChessboard() {
        return chessboard;
    }

    /**
     * toString Method
     * @return the name of current chess piece
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public abstract List<ChessboardPoint> canMoveTo();
}
