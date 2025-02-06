import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    ChessComponent[][] chessComponents;
    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        this.source=source;this.chessColor=chessColor;this.name=name;this.chessComponents=chessComponents;
    }

    public char getName(){
        return name;
    }
    public ChessColor getChessColor(){
        return chessColor;
    }
    public ChessboardPoint getSource(){
        return source;
    }
    public ChessComponent(){}
    //should design
//    public ChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
//        this.name=name;
//        this.source=source;
//        this.chessColor=ChessColor.WHITE;
//    }


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
    //public abstract boolean canMoveTo(ChessComponent[][] chessboard, ChessboardPoint destination);
}
