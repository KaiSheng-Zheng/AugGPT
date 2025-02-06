import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(int x,int y,ChessColor c){
        setSource(new ChessboardPoint(x,y));
        setChessColor(c);
        if(c == ChessColor.BLACK) {
            name = 'R';
        }else{
            name = 'r';
        }
    }
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = null;
        return a;
    }
}
