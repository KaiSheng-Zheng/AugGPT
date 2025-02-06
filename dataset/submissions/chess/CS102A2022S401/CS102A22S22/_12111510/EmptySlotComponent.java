import java.util.*;

public class EmptySlotComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

    public EmptySlotComponent(ChessboardPoint source,ChessColor chessColor,char name){
        super(source,chessColor,name);
        this.name='_';
    }
}

