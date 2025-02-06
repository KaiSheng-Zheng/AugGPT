import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;

    private ChessComponent[][] chessComponents;

    protected char name;

    //should design
    public ChessComponent(){}

    public void setChessComponents(ChessComponent[][] chessComponents){
        this.chessComponents = chessComponents;
    }

    public ChessComponent[][] getChessComponents(){
        return chessComponents;
    }

    public ChessColor getChessColor(){
        return chessColor;
    }
    public void setChessColor(char name){
        if (name >= 65 && name <= 90){
            chessColor = ChessColor.BLACK;
        }else if (name >= 97 && name <= 122){
            chessColor = ChessColor.WHITE;
        }else {
            chessColor = ChessColor.NONE;
        }
    }

    public void setSource(int x, int y){
        source = new ChessboardPoint(x, y);
    }
    public ChessboardPoint getSource(){
        return source;
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
