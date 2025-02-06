import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public ConcreteChessGame board;

    //should design
    public ChessComponent(){}

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ConcreteChessGame board) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
        this.board = board;
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
    public ChessboardPoint getSource(){
        return source;
    }
    public ChessColor getChessColor(){return chessColor;}
    public void setChessColor(ChessColor color){
        this.chessColor = color;
    }
    public void setSource(ChessboardPoint source){
        this.source = source;
    }
    public ChessboardPoint canStep(ChessboardPoint source){
        if (source == null){
            return null;
        }
        if (board.getChessComponents()[source.getX()][source.getY()].getChessColor() == chessColor){
            return null;
        } else {
            return source;
        }
    }
    public boolean hasOpponentChess(ChessboardPoint source){
        ChessColor color = board.getChessComponents()[source.getX()][source.getY()].getChessColor();
        if (color == (chessColor == ChessColor.BLACK ? ChessColor.WHITE : ChessColor.BLACK)){
            return true;
        } else {
            return false;
        }
    }

}
