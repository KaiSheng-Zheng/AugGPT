import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    public RookChessComponent(ChessboardPoint point, ChessColor color, ConcreteChessGame concreteChessGame) {
        super(point, color, concreteChessGame);
        if (getChessColor() == ChessColor.BLACK) name = 'R';
        else name = 'r';
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMovePoints = new ArrayList<>();
        ChessboardPoint point = getChessboardPoint();
        ChessComponent[][] temp = concreteChessGame.getChessComponents();
        for (int row = point.getX()+1, col = point.getY();row <= 7; row++){
            if (!(temp[row][col] instanceof EmptySlotComponent)){
                if (temp[row][col].getChessColor() != this.getChessColor()){
                    canMovePoints.add(temp[row][col].getChessboardPoint());
                }
                break;
            }
            canMovePoints.add(temp[row][col].getChessboardPoint());
        }
        for (int row = point.getX()-1, col = point.getY();row >= 0; row--){
            if (!(temp[row][col] instanceof EmptySlotComponent)){
                if (temp[row][col].getChessColor() != this.getChessColor()){
                    canMovePoints.add(temp[row][col].getChessboardPoint());
                }
                break;
            }
            canMovePoints.add(temp[row][col].getChessboardPoint());
        }
        for (int row = point.getX(), col = point.getY()-1;col >= 0; col--){
            if (!(temp[row][col] instanceof EmptySlotComponent)){
                if (temp[row][col].getChessColor() != this.getChessColor()){
                    canMovePoints.add(temp[row][col].getChessboardPoint());
                }
                break;
            }
            canMovePoints.add(temp[row][col].getChessboardPoint());
        }
        for (int row = point.getX(), col = point.getY()+1;col <= 7; col++){
            if (!(temp[row][col] instanceof EmptySlotComponent)){
                if (temp[row][col].getChessColor() != this.getChessColor()){
                    canMovePoints.add(temp[row][col].getChessboardPoint());
                }
                break;
            }
            canMovePoints.add(temp[row][col].getChessboardPoint());
        }
        return canMovePoints;
    }
}
