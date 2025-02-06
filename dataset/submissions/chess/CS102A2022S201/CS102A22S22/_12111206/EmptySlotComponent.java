import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo(){
        return new ArrayList<>();
    }
    public EmptySlotComponent(ChessColor chessColor , ChessboardPoint source){
        setChessColor(chessColor);
        setSource(source);
        this.name = '_';
    }
    public String toString(){
        return String.valueOf(this.name);
    }
}
