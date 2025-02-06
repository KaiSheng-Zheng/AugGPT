import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessboardPoint chessboardPoint;
    protected ChessComponent[][] chessComponents;

    //should design
    public ChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ChessComponent[][] chessComponents){
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
        this.chessComponents = chessComponents;
    }

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


    public void setName(char name) {
        this.name = name;}
    public char getName() {
        return name;
    }

    public void setChessColor(ChessColor chessColor){
        this.chessColor = chessColor;}
    public ChessColor getChessColor(){return chessColor;}

    public void setSource(ChessboardPoint source) {
        this.source = source;}
    public ChessboardPoint getSource() {return source;}


    public void setChessboardPoint(ChessboardPoint chessboardPoint) {
        this.chessboardPoint = chessboardPoint;
    }

    public ChessboardPoint getChessboardPoint() {
        return chessboardPoint;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }
    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

}


