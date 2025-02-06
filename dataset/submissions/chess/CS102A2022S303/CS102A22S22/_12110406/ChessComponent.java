import java.util.List;

public abstract class ChessComponent {


    //should design
    protected ChessboardPoint source;
    protected ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessComponent(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessComponent(char name, ChessColor chessColor, ChessboardPoint source) {
        this.name = name;
        this.chessColor = chessColor;
        this.source = source;
    }

    public ChessboardPoint getSource() {
        return source;
    }


    public ChessColor getChessColor() {
        return chessColor;
    }


    public char getName() {
        return name;
    }



    //should design
    public ChessComponent() {
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        String a= String.valueOf(name);
        return a;
    }

}
