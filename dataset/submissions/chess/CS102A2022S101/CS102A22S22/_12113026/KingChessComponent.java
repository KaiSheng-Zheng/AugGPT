import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor){
        this.setChessColor(chessColor);

        this.setSource(source);

        this.name = chessColor == ChessColor.BLACK ? 'K' : 'k';
    }

    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> points = new ArrayList<>();
        ChessboardPoint source = this.getSource();
        int x = source.getX();
        int y = source.getY();
        addPoint(points, source.offset(0, 1));
        addPoint(points, source.offset(0, -1));
        addPoint(points, source.offset(1, 0));
        addPoint(points, source.offset(-1, 0));
        addPoint(points, source.offset(1, 1));
        addPoint(points, source.offset(-1, -1));
        addPoint(points, source.offset(1, -1));
        addPoint(points, source.offset(-1, 1));

        return points;
    }
}
