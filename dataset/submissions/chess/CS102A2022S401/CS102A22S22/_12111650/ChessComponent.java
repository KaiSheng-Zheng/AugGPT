import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    static ChessComponent[][] chessComponents = new ChessComponent[8][8];

    //should design
    public ChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    public ChessComponent(){
    }


    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setSource(ChessboardPoint source){
        this.source = source;
    }

    public void setName(char name) {
        this.name = name;
    }

    public ChessColor getChessColor(){
        return chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public char getName(){
        return name;
    }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
