import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(char name, ChessColor chessColor,ChessboardPoint chessboardPoint) {
        setSource(chessboardPoint);
        this.chessColor=chessColor;
        this.name=name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints=new ArrayList<>();
        return chessboardPoints;
    }

}