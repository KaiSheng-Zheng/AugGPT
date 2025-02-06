import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    protected ChessComponent[][] chessComponents;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }
    private ChessColor chessColor;

    public ChessColor getChessColor() {
        return chessColor;
    }


    protected char name;

    public ChessboardPoint getChessboardPoint() {
        return source;
    }

    //should design
    public ChessComponent(){}

    public ChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        this.source=source;
        this.chessColor=chessColor;
        this.name = name;
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

    public void changetopoint(ChessboardPoint desitiny){
        this.source=desitiny;
    }


}
