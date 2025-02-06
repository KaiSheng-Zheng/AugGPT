import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(int x,int y,ChessColor c){
        setSource(new ChessboardPoint(x,y));
        setChessColor(c);
        if(c == ChessColor.BLACK) {
            name = 'N';
        }else{
            name = 'n';
        }
    }
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = null;
        return a;
    }
}
