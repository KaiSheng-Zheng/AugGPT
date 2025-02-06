import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
//    private ChessboardPoint source;
//    private ChessColor chessColor;
    private String name;
    public EmptySlotComponent(ChessColor chessColor,ChessboardPoint chessboardPoint){
        this.chessColor1=chessColor;
        this.source1=chessboardPoint;
        name="_";
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessboardPoint getSource(){
        return source1;
    }
}