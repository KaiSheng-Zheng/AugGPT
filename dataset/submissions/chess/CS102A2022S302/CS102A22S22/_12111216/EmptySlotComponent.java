import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent(ChessboardPoint source){
        this.name='_';
        this.setChessColor(ChessColor.NONE);
        this.setSource(source);
    }

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> kong = new ArrayList<>();

        return kong;
    }

    public String toString() {
        return name+"";
    }
}
