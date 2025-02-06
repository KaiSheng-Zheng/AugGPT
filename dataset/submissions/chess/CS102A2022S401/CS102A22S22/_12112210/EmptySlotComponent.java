import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent(int x,int y,ChessColor c){
        setChessColor(c);
        setSource(new ChessboardPoint(x,y));
        this.name = '_';
    }
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = null;
        return a;
    }
}
