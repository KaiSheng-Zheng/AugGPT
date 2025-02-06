import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{

    public EmptySlotComponent(char name,ChessColor c,ChessboardPoint s){
        super(name,c,s);
    }

    public EmptySlotComponent(char n){
        super(n);
    }

    public char getName(){
        return this.name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
