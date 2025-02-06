import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(char name,int x,int y) {
        if (name == '_') {
            this.name = name;
            this.setSource(new ChessboardPoint(x, y));
            this.setChessColor(ChessColor.NONE);
        }
    }
    public  List<ChessboardPoint> canMoveTo(){
        return new ArrayList<>();
    }
}
