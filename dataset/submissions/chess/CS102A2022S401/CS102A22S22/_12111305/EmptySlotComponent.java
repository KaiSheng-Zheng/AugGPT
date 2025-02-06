import java.util.*;

public class EmptySlotComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public EmptySlotComponent(ChessboardPoint source){
        this.source=source;
        chessColor=ChessColor.NONE;
        name='_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
    public ChessColor getChessColor(){
        return chessColor;
    }

    public String toString() {
        return "_";
    }
}
