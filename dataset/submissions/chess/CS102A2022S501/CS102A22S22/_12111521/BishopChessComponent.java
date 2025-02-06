import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{

    public BishopChessComponent() {
    }

    public BishopChessComponent(ChessboardPoint chessboardPoint, ChessColor color,char name) {
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
            int sum = source.getX() + source.getY();
            int dif = source.getX() - source.getY();
            if (dif == destination.getX()-destination.getY()) {
                for (int x = Math.min(source.getX(), destination.getX()) + 1;
                     x < Math.max(source.getX(), destination.getX()); x++) {
                    if (!(chessComponents[x][x-dif] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            } else if (sum == destination.getX() + destination.getY()) {
                for (int x = Math.min(source.getX(), destination.getX()) + 1;
                     x < Math.max(source.getX(), destination.getX()); x++) {
                    if (!(chessComponents[x][sum-x] instanceof EmptySlotComponent)) {
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
