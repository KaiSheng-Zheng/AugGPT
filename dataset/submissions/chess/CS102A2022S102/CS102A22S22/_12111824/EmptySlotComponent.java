import java.util.*;

public class EmptySlotComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo(){
        return realCanMoveTo(chessComponents);
    }
    public List<ChessboardPoint> realCanMoveTo(ChessComponent[][] X){
        return new ArrayList<>();
    }

    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }
}