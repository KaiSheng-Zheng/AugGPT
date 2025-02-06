import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
protected ChessComponent[][] chessComponents=new ChessComponent[8][8];
    //should design
    public ChessComponent(){}

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return name+"";
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

    public boolean checkColor(ChessComponent h){
        if(this.getChessColor().equals(h.getChessColor())){return false;}
        else return true;
    }
    public boolean checkInbound(int i){if (i<=7&&i>=0)return true;
    else return false;}
}
