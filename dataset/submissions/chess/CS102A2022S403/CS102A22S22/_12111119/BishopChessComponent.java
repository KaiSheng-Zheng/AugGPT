import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint point, ChessColor color, ConcreteChessGame concreteChessGame) {
        super(point, color, concreteChessGame);
        if (getChessColor() == ChessColor.BLACK) name = 'B';
        else name = 'b';
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMovePoints = new ArrayList<>();
        ChessboardPoint point = getChessboardPoint();
        ChessComponent temp;
        for (int row = point.getX()+1, col = point.getY()+1;row <= 7 && col <=7; row++, col++){
            temp = concreteChessGame.getChessComponents()[row][col];
            if (!(temp instanceof EmptySlotComponent)){
                if (temp.getChessColor() != this.getChessColor()){
                    canMovePoints.add(temp.getChessboardPoint());
                }
                break;
            }
            canMovePoints.add(temp.getChessboardPoint());
        }
        for (int row = point.getX()-1, col = point.getY()+1;row >= 0 && col <=7; row--, col++){
            temp = concreteChessGame.getChessComponents()[row][col];
            if (!(temp instanceof EmptySlotComponent)){
                if (temp.getChessColor() != this.getChessColor()){
                    canMovePoints.add(temp.getChessboardPoint());
                }
                break;
            }
            canMovePoints.add(temp.getChessboardPoint());
        }
        for (int row = point.getX()-1, col = point.getY()-1;row >= 0 && col >=0; row--, col--){
            temp = concreteChessGame.getChessComponents()[row][col];
            if (!(temp instanceof EmptySlotComponent)){
                if (temp.getChessColor() != this.getChessColor()){
                    canMovePoints.add(temp.getChessboardPoint());
                }
                break;
            }
            canMovePoints.add(temp.getChessboardPoint());
        }
        for (int row = point.getX()+1, col = point.getY()-1;row <= 7 && col >= 0; row++, col--){
            temp = concreteChessGame.getChessComponents()[row][col];
            if (!(temp instanceof EmptySlotComponent)){
                if (temp.getChessColor() != this.getChessColor()){
                    canMovePoints.add(temp.getChessboardPoint());
                }
                break;
            }
            canMovePoints.add(temp.getChessboardPoint());
        }
        return canMovePoints;
    }
}
