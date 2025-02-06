import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public EmptySlotComponent(ChessboardPoint source){
        this.name='_';
        this.source=source;
        this.chessColor=ChessColor.NONE;
    }

    @Override
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    @Override
    public ChessboardPoint getSource() {
        return source;
    }

    public char getName() {
        return name;
    }

    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
