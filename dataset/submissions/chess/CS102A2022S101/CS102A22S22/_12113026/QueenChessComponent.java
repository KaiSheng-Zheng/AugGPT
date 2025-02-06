import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor){
      this.setSource(source);
      this.setChessColor(chessColor);
      this.name = chessColor == ChessColor.BLACK ? 'Q' : 'q';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> points = new ArrayList<>();
        ChessboardPoint point;
        ChessboardPoint source = this.getSource();
        ChessComponent[][] chessComponents = ChessComponent.getChessComponents();

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

        for(int i=1; i<=7; i++) {
            if( !addPoint(points, source.offset(i, i)) ) break;
        }

        for(int i=1; i<=7; i++) {
            if( !addPoint(points, source.offset(-i, -i)) ) break;
        }

        for(int i=1; i<=7; i++) {
            if( !addPoint(points, source.offset(i, -i)) ) break;
        }

        for(int i=1; i<=7; i++) {
            if( !addPoint(points, source.offset(-i, i)) ) break;
        }

        return points;
    }
}
