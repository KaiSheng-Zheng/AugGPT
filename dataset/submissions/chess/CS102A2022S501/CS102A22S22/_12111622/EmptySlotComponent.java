import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private ChessColor color=ChessColor.NONE;
    private ChessboardPoint chessboardPoint;

    public ChessColor getColor() {
        return color;
    }

    public ChessboardPoint getChessboardPoint() {
        return chessboardPoint;
    }
public void setChessboardPoint(ChessboardPoint chessboardPoint) {
        this.chessboardPoint = chessboardPoint;
    }
    public EmptySlotComponent( ChessboardPoint chessboardPoint){
        this.chessboardPoint=chessboardPoint;
        super.name='_';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}