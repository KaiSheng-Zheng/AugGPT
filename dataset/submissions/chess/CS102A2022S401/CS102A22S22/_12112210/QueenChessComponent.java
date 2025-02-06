import java.util.List;

public class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(int x,int y,ChessColor c){
        setSource(new ChessboardPoint(x,y));
        setChessColor(c);
        if(c == ChessColor.BLACK) {
            name = 'Q';
        }else{
            name = 'q';
        }
    }
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = null;
        return a;
    }
}
