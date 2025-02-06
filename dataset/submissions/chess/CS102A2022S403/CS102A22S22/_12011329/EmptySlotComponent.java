import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint chessboardPoint,ChessColor color) {
        this.name='_';
        ChessComponent[][] components=new ChessComponent[8][8];
        this.setSource(chessboardPoint);
        this.setChessColor(color);
        this.setChessboard(components);
    }

    public List<ChessboardPoint> canMoveTo(){
        return new ArrayList<>();
    }
}
