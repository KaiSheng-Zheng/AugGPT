import java.awt.*;
import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;

    //should design
    public ChessComponent(){}

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public ChessComponent(ChessColor chessColor, ChessComponent[][] chessComponents){
        this.chessColor=chessColor;
        this.chessComponents=chessComponents;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public char getName() {
        return name;
    }

    public void swapLocation(ChessComponent another) {
        ChessboardPoint chessboardPoint1 = getSource(), chessboardPoint2 = another.getSource();
        setSource(chessboardPoint2);
        another.setSource(chessboardPoint1);
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
}
