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

    public void setChessColor(ChessColor color){
        chessColor = color;
    }
    public void setSource(int sourceX,int sourceY){
        source = new ChessboardPoint(sourceX ,sourceY);
    }
    public void setName(char name){
        this.name = name;
    }
    public ChessboardPoint getSource(){
        return source;
    }
    public ChessColor getChessColor(){
        return chessColor;
    }
}
