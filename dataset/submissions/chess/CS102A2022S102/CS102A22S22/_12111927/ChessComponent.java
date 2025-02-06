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

    public ChessboardPoint getSource(){
        return source;
    }

    public void setSource(ChessboardPoint source){
        this.source=source;
    }

    public ChessColor getChessColor(){
        return chessColor;
    }

    public void setChessColor(ChessColor color){
        this.chessColor = color;
    }

    public char getName(){
        return name;
    }

    public void setName(char name){
        this.name=name;
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
