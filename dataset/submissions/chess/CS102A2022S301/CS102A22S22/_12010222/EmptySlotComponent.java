import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo(){return null;}
    public EmptySlotComponent(char name){
        this.name=name;
    }
}