import java.util.List;

public abstract class ChessComponent {
    //should design
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

    public void setName(char name){
         this.name = name;
    }

    public char getName(){
        return this.name;
    }

    public void setSource(ChessboardPoint source){
        this.source = source;
    }

    public ChessboardPoint getSource(){
        return this.source;
    }

    public void setChessColor(ChessColor chessColor){
        this.chessColor = chessColor;
    }

    public ChessColor getChessColor(){
        return this.chessColor;
    }

}
