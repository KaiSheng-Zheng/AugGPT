import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    private static ChessComponent[][] chessComponents;
    public static void setChessboardPoints(ChessComponent[][] chessComponents) {
        ChessComponent.chessComponents = chessComponents;
    }
    protected static ChessComponent[][] getChessComponents(){return chessComponents;}

    //should design
    public ChessComponent(){
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(name);
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    boolean addPoint(ArrayList<ChessboardPoint> points, ChessboardPoint point) {
        if(point == null) return false;

        if (chessComponents[point.getX()][point.getY()].getChessColor() == this.getChessColor())
            return false;

        points.add(point);

        return chessComponents[point.getX()][point.getY()] instanceof EmptySlotComponent;
    }
}
