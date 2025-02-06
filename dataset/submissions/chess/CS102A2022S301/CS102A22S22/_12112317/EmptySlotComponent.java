import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> result = new ArrayList<>();
        return result;

    }
    public EmptySlotComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name,ChessComponent[][] chessComponents) {
        super();
        this.setSource(chessboardPoint);
        this.setChessColor(chessColor);
        this.name = name;
        this.chessComponents = chessComponents;
    }

}
