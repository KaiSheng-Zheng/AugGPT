import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;
    private ChessColor getCurrentColor;
    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
    public void load(ChessComponent[][] chessComponents, ChessColor chessColor){
        this.chessComponents = chessComponents;
        this.getCurrentColor=chessColor;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;

    }



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
    public ChessColor getChessColor() {
        return chessColor;
    }
    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }
    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

}
