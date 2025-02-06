import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint source,ChessColor chessColor,char name,ConcreteChessGame concreteChessGame){
        this.name=name;
        setChessColor(ChessColor.NONE);
        setSource(source);
        setConcreteChessGame(concreteChessGame);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}