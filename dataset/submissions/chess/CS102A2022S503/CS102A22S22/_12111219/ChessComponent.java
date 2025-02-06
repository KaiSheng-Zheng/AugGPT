import java.util.List;
public abstract class ChessComponent {
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    //should design
    protected ChessComponent[][] chessComponents=new ChessComponent[8][8];



    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    //should design
    public ChessComponent(){}

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

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public boolean Occupied(ChessComponent chessComponent1,ChessComponent chessComponent2){
        if(chessComponent1.getChessColor()==chessComponent2.getChessColor()){
            return false;
        }
        return true;
    }

    public boolean Occupied2(ChessComponent chessComponent1,ChessComponent chessComponent2){
        if(chessComponent1.getChessColor()==ChessColor.WHITE&&chessComponent2.getChessColor()==ChessColor.BLACK){
            return true;
        }else if(chessComponent2.getChessColor()==ChessColor.WHITE&&chessComponent1.getChessColor()==ChessColor.BLACK){
            return true;
        }
        return false;
    }

    //public ChessComponent[][] getChessComponents(ChessComponent[][] chessComponents){return chessComponents;}
}

