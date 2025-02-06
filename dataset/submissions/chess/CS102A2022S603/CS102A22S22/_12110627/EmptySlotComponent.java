import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;
    public EmptySlotComponent(ChessboardPoint source,ChessColor chessColor,char name) {
        this.name=name;
        setChessColor(chessColor);
        setSource(source);
    }
    public ChessComponent[][] getChessComponent(){
        return chessComponents;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
