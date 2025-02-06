import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private boolean isFirstStep;

    public PawnChessComponent(ChessboardPoint point, ChessColor color, ConcreteChessGame concreteChessGame) {
        super(point, color, concreteChessGame);
        if (getChessColor() == ChessColor.BLACK) name = 'P';
        else name = 'p';
        isFirstStep = false;
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMovePoints = new ArrayList<>();
        ChessboardPoint point = getSource();
        ChessComponent[][] temp = concreteChessGame.getChessComponents();
        int row = point.getX(), col = point.getY();
        if (getChessColor() == ChessColor.BLACK && this.getSource().getX() == 1) isFirstStep=true;
        else if (getChessColor() == ChessColor.WHITE && this.getSource().getX() == 6) isFirstStep=true;
        if (isFirstStep)
        {
            for (int i = 1 ; i <= 2; i++){
                // white should be row-i
                if (!(temp[row+i][col] instanceof EmptySlotComponent)){
                    break;
                }
                canMovePoints.add(temp[row+i][col].getSource());
            }
            if (col == 0){
                if (!(temp[row+1][col+1] instanceof EmptySlotComponent) && temp[row+1][col+1].getChessColor() != getChessColor()){
                    canMovePoints.add(temp[row+1][col+1].getSource());
                }
            }else if (col == 7){
                if (!(temp[row+1][col-1] instanceof EmptySlotComponent) && temp[row+1][col-1].getChessColor() != getChessColor()){
                    canMovePoints.add(temp[row+1][col-1].getSource());
                }
            }else{
                for (int i = -1; i < 2; i += 2){
                    if (!(temp[row+1][col+i] instanceof EmptySlotComponent) && temp[row+1][col+i].getChessColor() != getChessColor()){
                        canMovePoints.add(temp[row+1][col+i].getSource());
                    }
                }
            }
        }
        else {
            if (!(temp[row + 1][col] instanceof EmptySlotComponent)) {
                canMovePoints.add(temp[row + 1][col].getSource());
            }
            if (col == 0) {
                if (!(temp[row + 1][col + 1] instanceof EmptySlotComponent) && temp[row + 1][col + 1].getChessColor() != getChessColor()) {
                    canMovePoints.add(temp[row + 1][col + 1].getSource());
                }
            } else if (col == 7) {
                if (!(temp[row + 1][col - 1] instanceof EmptySlotComponent) && temp[row + 1][col - 1].getChessColor() != getChessColor()) {
                    canMovePoints.add(temp[row + 1][col - 1].getSource());
                }
            } else {
                for (int i = -1; i < 2; i += 2) {
                    if (!(temp[row + 1][col + i] instanceof EmptySlotComponent) && temp[row + 1][col + i].getChessColor() != getChessColor()) {
                        canMovePoints.add(temp[row + 1][col + i].getSource());
                    }
                }
            }
        }
        return canMovePoints;
    }
}
