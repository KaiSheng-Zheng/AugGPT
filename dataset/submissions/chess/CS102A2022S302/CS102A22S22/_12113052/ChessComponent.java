import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;//where the chess is
    private ChessColor chessColor;
    protected char name;
    ChessComponent[][] chessComponents;
    protected ChessComponent[][]chessboard;
    //should design
    public ChessComponent(ChessboardPoint source,ChessColor chessColor){
        this.source=source;
        this.chessColor=chessColor;
    }

    public ChessComponent(){}

    public ChessColor getComponentColor(char component){
        if (component=='_') {
            return ChessColor.NONE;
        }else if (component>='A'&&component<='Z'){
            return ChessColor.BLACK;
        }else return ChessColor.WHITE;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public ChessboardPoint getSource() {
        return source;
    }

    /**
     * should design
     * @return
     */
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
}




