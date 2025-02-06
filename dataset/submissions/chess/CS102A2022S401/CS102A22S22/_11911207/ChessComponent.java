
import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public ChessComponent[][] chessComponents = new ChessComponent[8][8];

    //should design
    public ChessComponent(){
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public int getLine(){
        return source.getX();
    }

    public int getColumn(){
        return source.getY();
    }

    public ChessboardPoint getSource() {
        return source;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public void setName(char name) {
        this.name = name;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

}