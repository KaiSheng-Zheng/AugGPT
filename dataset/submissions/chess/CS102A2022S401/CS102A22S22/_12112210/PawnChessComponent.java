import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(int x,int y,ChessColor c){
        setSource(new ChessboardPoint(x,y));
        setChessColor(c);
        if(c == ChessColor.BLACK) {
            name = 'P';
        }else{
            name = 'p';
        }
    }
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = null;
        return a;
    }
}
