import java.util.ArrayList;
import java.util.List;
public class EmptySlotComponent extends ChessComponent {
    ChessboardPoint source;
    ChessColor chessColor;
    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }
    public EmptySlotComponent() {}
    public  List<ChessboardPoint> canMoveTo(){
        return new ArrayList<>();
    }

}
