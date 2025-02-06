import java.util.ArrayList;
import java.util.List;
public class EmptySlotComponent extends ChessComponent{

    public EmptySlotComponent(ChessboardPoint source,ChessColor chessColor, char name,List<String> chessboard ){
        super(source,chessColor,name,chessboard);

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
    public void setName(char a) {
        super.setName(a);
    }

    public void setChessColor(ChessColor chessColor) {
        super.setChessColor(chessColor);
    }

    public void setSource(ChessboardPoint source) {
        super.setSource(source);
    }
}
