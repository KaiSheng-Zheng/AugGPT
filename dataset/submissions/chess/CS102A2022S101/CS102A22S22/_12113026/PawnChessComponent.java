import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor){
        this.setSource(source);
        this.setChessColor(chessColor);
        this.name = chessColor == ChessColor.BLACK ? 'P' : 'p';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> points = new ArrayList<>();

        ChessboardPoint source = this.getSource();
        ChessColor chessColor = this.getChessColor();
        int dir = chessColor == ChessColor.BLACK ? 1 : -1;

        if(addPoint(points, source.offset(dir, 0))){
            if(source.getX() == 1 || source.getX() == 6){
                if(!addPoint(points, source.offset(dir+dir, 0)) && points.size() == 2){
                    points.remove(1);
                }
            }
        } else if(points.size() == 1){
            points.remove(0);
        }

        if( addPoint(points, source.offset(dir, -1)) )
            points.remove(points.size()-1);

        if( addPoint(points, source.offset(dir, 1)))
            points.remove(points.size()-1);

        return points;
    }
}
