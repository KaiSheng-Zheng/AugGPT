import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessColor chessColor, ChessboardPoint source, char name){
        super(source, chessColor, name);
    }
    public EmptySlotComponent(ChessColor chessColor, char name){
        super(chessColor, name);
    }
    public List<ChessboardPoint> canMoveTo(){
        return new ArrayList<>();
    }
}
