import java.util.List;

public class EmptySlotComponent extends ChessComponent{

    private ChessboardPoint point;
    private ChessColor chessColor;
    private final char name = '_';

    private  ConcreteChessGame belong;

    public EmptySlotComponent(ChessboardPoint point, ChessColor chessColor, ConcreteChessGame concreteChessGame){
        this.point = point;
        this.chessColor = chessColor;
        this.belong = concreteChessGame;
    }

    public ChessboardPoint getPoint() {
        return point;
    }

    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    @Override
    public char getName() {
        return name;
    }

    public ConcreteChessGame getBelong() {
        return belong;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
