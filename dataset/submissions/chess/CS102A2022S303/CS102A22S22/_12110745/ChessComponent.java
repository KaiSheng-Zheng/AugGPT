import java.util.List;


public abstract class ChessComponent{
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    //user defined
    protected static ChessComponent[][] chessboard = new ChessComponent[8][8];

    public boolean isEnemy(ChessComponent chessComponent){
        if (this.chessColor == chessComponent.chessColor){
            return false;
        }else{
            return true;
        }
    }

    public boolean isEmpty(ChessComponent chessComponent){
        if (chessComponent instanceof EmptySlotComponent){
            return true;
        }else{
            return false;
        }
    }

    public void setChessboard(ChessComponent[][] chessboard) {
        ChessComponent.chessboard = chessboard;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    //should design
    public ChessComponent(){}

    public ChessComponent(ChessboardPoint source, ChessColor chessColor) {
        this.source = source;
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

    public void setName(char name) {
        this.name = name;
    }

}

