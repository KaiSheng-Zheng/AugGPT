import java.awt.*;
import java.util.List;
import java.util.Objects;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    protected ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;

    //should design
    public ChessComponent(){}

    public ChessComponent(ChessboardPoint source,ChessComponent[][] chessComponents, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
        this.chessComponents = chessComponents;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

//    public void swapLocation(ChessComponent another) {
//        ChessboardPoint chessboardPoint1 = getSource(), chessboardPoint2 = another.getSource();
//        Point point1 = getLocation(), point2 = another.getLocation();
//        setChessboardPoint(chessboardPoint2);
//        setLocation(point2);
//        another.setChessboardPoint(chessboardPoint1);
//        another.setLocation(point1);
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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ChessComponent that = (ChessComponent) o;
//        return name == that.name && Objects.equals(source, that.source) && chessColor == that.chessColor;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(source, chessColor, name);
//    }
}
