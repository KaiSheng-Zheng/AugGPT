import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    public RookChessComponent() {
    }

    public RookChessComponent(ChessboardPoint chessboardPoint, ChessColor color,char name) {
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
            if (source.getX() == destination.getX()) {
                int x = source.getX();
                for (int y = Math.min(source.getY(), destination.getY()) + 1;
                     y < Math.max(source.getY(), destination.getY()); y++) {
                    if (!(chessComponents[x][y] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            } else if (source.getY() == destination.getY()) {
                int y = source.getY();
                for (int x = Math.min(source.getX(), destination.getX()) + 1;
                     x < Math.max(source.getX(), destination.getX()); x++) {
                    if (!(chessComponents[x][y] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            } else { // Not on the diagonal.
                return false;
            }
            return true;
        }else {
            return false;
        }
    }

}
