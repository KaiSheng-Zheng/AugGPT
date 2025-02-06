import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor){
        this.setSource(source);
        this.setChessColor(chessColor);
        this.name = chessColor == ChessColor.BLACK ? 'B' : 'b';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> points = new ArrayList<>();
        ChessboardPoint source = this.getSource();

        for(int i=1; i<=7; i++) {
            if( !addPoint(points, source.offset(i, i)) ) break;
        }
        for(int i=1; i<=7; i++) {
            if( !addPoint(points, source.offset(-i, -i)) ) break;
        }
        for(int i=1; i<=7; i++) {
            if( !addPoint(points, source.offset(-i, i)) ) break;
        }
        for(int i=1; i<=7; i++) {
            if( !addPoint(points, source.offset(i, -i)) ) break;
        }

        return points;
    }
}
