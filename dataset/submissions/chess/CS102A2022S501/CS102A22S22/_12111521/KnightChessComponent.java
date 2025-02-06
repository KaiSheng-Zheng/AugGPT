import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

    public KnightChessComponent() {
    }

    public KnightChessComponent(ChessboardPoint chessboardPoint, ChessColor color,char name) {
        super(chessboardPoint,color,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> points = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint destination = new ChessboardPoint(i,j);
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
            return 5 == (source.getX() - destination.getX()) * (source.getX() - destination.getX())
                    + (source.getY() - destination.getY()) * (source.getY() - destination.getY());
        }
        return false;
    }
}
