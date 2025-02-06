import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{

    public EmptySlotComponent(ChessComponent[][] chessboard,ChessboardPoint source,char name) {
        super(chessboard,source,name);
        this.chessboard=chessboard;
//        this.source=source;
        setSource(source);
        this.name=name;
    }
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
