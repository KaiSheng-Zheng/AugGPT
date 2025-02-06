import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    protected char name;
    ChessColor chessColor;
    public EmptySlotComponent(){
      name='_';
      chessColor=ChessColor.NONE;
    }
    @Override
    public String toString() {
        return "_";
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
       return new ArrayList<>();
    }
}
