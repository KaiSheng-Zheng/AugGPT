import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(int x,int y,ChessColor c){
        setSource(new ChessboardPoint(x,y));
        setChessColor(c);
        if(c == ChessColor.BLACK) {
            name = 'B';
        }else{
            name = 'b';
        }
    }
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = null;
        return a;
    }
}
