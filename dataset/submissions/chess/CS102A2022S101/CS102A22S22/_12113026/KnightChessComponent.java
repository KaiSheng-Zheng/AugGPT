import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor){
        this.setSource(source);
        this.setChessColor(chessColor);
        this.name = chessColor == ChessColor.BLACK ? 'N' : 'n';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> points = new ArrayList<>();
        ChessboardPoint source = getSource();

            addPoint(points, source.offset(2, 1));
            addPoint(points, source.offset(2, -1));
            addPoint(points, source.offset(-2, 1));
            addPoint(points, source.offset(-2, -1));
            addPoint(points, source.offset(1, 2));
            addPoint(points, source.offset(1, -2));
            addPoint(points, source.offset(-1, 2));
            addPoint(points, source.offset(-1, -2));
        return points;
    }
}
