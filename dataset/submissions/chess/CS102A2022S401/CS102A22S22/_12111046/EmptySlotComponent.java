import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(int x,int y,char name){
        super(x,y,name);

    }
    public List<ChessboardPoint> canMoveTo(){
        return new ArrayList<>();
    }
}
