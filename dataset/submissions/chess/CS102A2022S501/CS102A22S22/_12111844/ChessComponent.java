import java.util.List;

public abstract class ChessComponent{
    //should design
    private ChessboardPoint source;
    // Where the chess is
    private ChessColor chessColor;
    // What's the color
    protected char name;
    // What's the name
    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
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



    //should design
    public ChessComponent(){}
    protected ChessComponent[][] chessboard = new ChessComponent[8][8];
    public ChessComponent(ChessComponent[][] chessboard){
        this.chessboard = chessboard;
    }

    public ChessComponent(ChessboardPoint source,ChessColor chessColor, char name, ChessComponent[][] chessboard){
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
        this.chessboard = chessboard;
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
