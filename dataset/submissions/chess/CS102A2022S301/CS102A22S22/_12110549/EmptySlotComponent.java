import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;

    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name) {
      
        this.name=name;
        this.source=source;
        this.chessColor=chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

    
}