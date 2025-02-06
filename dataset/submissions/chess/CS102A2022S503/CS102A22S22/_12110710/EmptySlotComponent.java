import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public EmptySlotComponent(ChessboardPoint source,ChessColor chessColor,char name){
        this.chessColor=ChessColor.NONE;
        this.source=source;
        this.name=name;
    }
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
    public String toString(){
        return "_";
    }
}
