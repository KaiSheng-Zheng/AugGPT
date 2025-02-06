import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {

    private ChessboardPoint source;
    private ChessColor chessColor;

    public EmptySlotComponent() {
        super();
    }

    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
        this.source = source;
        this.chessColor = chessColor;
    }

    @Override
    public void setSource(ChessboardPoint source) {
        super.setSource(source);
    }


    @Override
    public ChessboardPoint getSource() {
        return source;
    }

    @Override
    public ChessColor getChessColor() {
        return super.getChessColor();
    }

    @Override
    public ChessboardPoint getChessboardPoint() {
        return super.getChessboardPoint();
    }

    @Override
    public void setSource(int targetX, int targetY) {
        this.source = new ChessboardPoint(targetX,targetY);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
