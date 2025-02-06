import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private ConcreteChessGame game;
    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name,ConcreteChessGame game,ChessComponent[][] chessComponents){
        super( source,  chessColor,  name,chessComponents);
    }

    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name,ConcreteChessGame game){
        super( source,  chessColor,  name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
