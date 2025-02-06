import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessComponent[][] chessComponents;
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
    public EmptySlotComponent(char name, ChessComponent[][] chessComponents, ChessboardPoint source){
        super(name,chessComponents,source);
        this.name=name;
        this.source=source;
        this.chessComponents=chessComponents;
    }

}
