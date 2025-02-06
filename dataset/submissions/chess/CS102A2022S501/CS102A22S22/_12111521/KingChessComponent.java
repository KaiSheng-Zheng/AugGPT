import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent() {
    }

    public KingChessComponent(ChessboardPoint chessboardPoint, ChessColor color,char name) {
        super(chessboardPoint,color,name);
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> points = new ArrayList<>();
        ChessComponent[][] chessboard = getChessboard();
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard[i].length; j++) {
                ChessboardPoint destination = chessboard[i][j].getSource();
                if(canMove(chessboard,destination)){
                    points.add(new ChessboardPoint(i,j));
                }
            }
        }
        return points;
    }


    public boolean canMove(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getSource();
        if(chessComponents[destination.getX()][destination.getY()].getChessColor()
                != this.getChessColor()){
            return (1 == (source.getX() - destination.getX()) * (source.getX() - destination.getX())
                    + (source.getY() - destination.getY()) * (source.getY() - destination.getY()))
                    || (2 == (source.getX() - destination.getX()) * (source.getX() - destination.getX())
                    + (source.getY() - destination.getY()) * (source.getY() - destination.getY()));
        }
        return false;
    }
}
