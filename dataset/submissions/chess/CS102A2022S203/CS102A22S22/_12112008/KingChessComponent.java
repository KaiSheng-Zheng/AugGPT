
import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {


    public KingChessComponent(int x, int y, ChessColor color,ConcreteChessGame concreteChessGame) {
        super(x, y, color,concreteChessGame);
    }



    public boolean move(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        return true;
//        ChessboardPoint source = getChessboardPoint();
//        if (this.getChessColor()==chessComponents[destination.getX()][destination.getY()].getChessColor())return false;
//        ChessComponent e = chessComponents[destination.getX()][destination.getY()];
//        if (destination.getX() > 8 || destination.getX() < 0) return false;
//        if (destination.getY() > 8 || destination.getY() < 0) return false;
//        int rowD = Math.abs(source.getX() - destination.getX());
//        int colD = Math.abs(source.getY() - destination.getY());
//        if (0 <= rowD && rowD <= 1 && 0 <= colD && colD <= 1 && rowD + colD > 0 && (e.getChessColor()!= this.getChessColor())) {
//           return true;
//        }
//        return false;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<ChessboardPoint>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessComponent e = belonging.getChessComponents()[i][j];
                if (this.move(belonging.getChessComponents(), e.getChessboardPoint())) chessboardPoints.add(e.getChessboardPoint());
            }

        }
        return chessboardPoints;
    }

}
