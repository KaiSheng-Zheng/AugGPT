import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private ChessboardPoint source;

    EmptySlotComponent(ChessboardPoint source){
        int x = source.getX();
        int y = source.getY();
        this.source = source;
    }

    public int getX(){return source.getX();}

    public int getY(){return source.getY();}

    public List<ChessboardPoint> canMoveTo(){ return new ArrayList<>();}

    @Override
    public String toString() {
        return "_";
    }
}
