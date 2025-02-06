import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{

    public QueenChessComponent() {
    }

    public QueenChessComponent(ChessboardPoint chessboardPoint, ChessColor color,char name) {
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
            } else if (source.getX() == destination.getX()) {
                int row = source.getX();
                for (int col = Math.min(source.getY(), destination.getY()) + 1;
                     col < Math.max(source.getY(), destination.getY()); col++) {
                    if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            } else if (source.getY() == destination.getY()) {
                int col = source.getY();
                for (int row = Math.min(source.getX(), destination.getX()) + 1;
                     row < Math.max(source.getX(), destination.getX()); row++) {
                    if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            } else { // Not on the diagonal and the same row or column.
                return false;
            }
            return true;
        }else {
            return false;
        }
    }
}
