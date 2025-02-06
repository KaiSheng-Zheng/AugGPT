import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(int x, int y,ChessColor color,char name){
        super(x, y, color, name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        return new ArrayList<>();
    }
    @Override
    public String toString(){
        return "6666";
    }
}
