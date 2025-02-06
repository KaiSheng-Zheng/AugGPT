import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    private ChessComponent[][] chessComponents;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessComponent() {
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    protected char name;

    //should design
    public ChessComponent(ChessboardPoint source,ChessColor chessColor,char name) {
        this.source=source;this.name=name;this.chessColor=chessColor;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();
//    public boolean MoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination){};


    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
      return String.valueOf(this.name);
    }

    public char getName() {
        return name;
    }
}
