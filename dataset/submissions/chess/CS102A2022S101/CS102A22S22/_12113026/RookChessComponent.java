import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor){
        this.setSource(source);
        this.setChessColor(chessColor);
        this.name = chessColor == ChessColor.BLACK ? 'R' : 'r';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> points = new ArrayList<>();
        ChessboardPoint source = this.getSource();

        for(int i=1; i<=7; i++) {
            if( !addPoint(points, source.offset(i, 0)) ) break;
        }
        for(int i=1; i<=7; i++) {
            if( !addPoint(points, source.offset(-i, 0)) ) break;
        }
        for(int i=1; i<=7; i++) {
            if( !addPoint(points, source.offset(0, i)) ) break;
        }
        for(int i=1; i<=7; i++) {
            if( !addPoint(points, source.offset(0, -i)) ) break;
        }

        return points;
    }
}
