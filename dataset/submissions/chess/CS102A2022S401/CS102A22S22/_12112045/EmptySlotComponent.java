import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name='_';

    public EmptySlotComponent(ChessboardPoint source,ChessColor chessColor,char name) {
        this.source = source;
        this.chessColor=chessColor;
        this.name=name;
    }

    public char getName() {
        return name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList< >();
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}