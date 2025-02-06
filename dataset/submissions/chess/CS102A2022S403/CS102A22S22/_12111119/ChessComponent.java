import java.awt.*;
import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ConcreteChessGame concreteChessGame;

    //should design
    public ChessComponent(){}

    public ChessComponent(ChessboardPoint point, ChessColor color, ConcreteChessGame concreteChessGame){
        source = point;
        chessColor = color;
        this.concreteChessGame = concreteChessGame;
    }

    public ChessboardPoint getChessboardPoint() {
        return source;
    }

    public void setChessboardPoint(ChessboardPoint chessboardPoint) {
        this.source = chessboardPoint;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void swapLocation(ChessComponent another) {
        ChessboardPoint chessboardPoint1 = getChessboardPoint(), chessboardPoint2 = another.getChessboardPoint();
        setChessboardPoint(chessboardPoint2);
        another.setChessboardPoint(chessboardPoint1);
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

}
