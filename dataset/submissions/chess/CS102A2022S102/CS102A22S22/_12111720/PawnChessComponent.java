import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(char name) {
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> movablePoints = new ArrayList<>();
        int row = this.getSource().getX(), col = this.getSource().getY();
        if (this.getChessColor() == ChessColor.BLACK){
            if (this.getSource().getX() == 1){
                for (int i = row + 1; i <= row + 2; i++){
                    if (getChessComponents()[i][col] instanceof EmptySlotComponent){
                        movablePoints.add(new ChessboardPoint(i, col));
                    }
                }
            }else {
                if (getChessComponents()[row + 1][col] instanceof EmptySlotComponent){
                    movablePoints.add(new ChessboardPoint(row + 1, col));
                }
            }
            if (getChessComponents()[row + 1][col + 1].getChessColor() == ChessColor.WHITE){
                movablePoints.add(new ChessboardPoint(row + 1, col + 1));
            }
            if (getChessComponents()[row + 1][col - 1].getChessColor() == ChessColor.WHITE){
                movablePoints.add(new ChessboardPoint(row + 1, col - 1));
            }
        }else if (this.getChessColor() == ChessColor.WHITE){
            if (this.getSource().getX() == 6){
                for (int i = row - 1; i >= row - 2; i--){
                    if (getChessComponents()[i][col] instanceof EmptySlotComponent){
                        movablePoints.add(new ChessboardPoint(i, col));
                    }
                }
            }else {
                if (getChessComponents()[row - 1][col] instanceof EmptySlotComponent){
                    movablePoints.add(new ChessboardPoint(row - 1, col));
                }
            }
            if (getChessComponents()[row - 1][col + 1].getChessColor() == ChessColor.BLACK){
                movablePoints.add(new ChessboardPoint(row - 1, col + 1));
            }
            if (getChessComponents()[row - 1][col - 1].getChessColor() == ChessColor.BLACK){
                movablePoints.add(new ChessboardPoint(row - 1, col - 1));
            }
        }

        for (int i = 0; i < movablePoints.size(); i++){
            boolean change = false;
            for (int j = i + 1; j < movablePoints.size(); j++){
                ChessboardPoint temp = movablePoints.get(i);

                if (temp.getX() > movablePoints.get(j).getX()){
                    movablePoints.set(i, movablePoints.get(j));
                    movablePoints.set(j, temp);
                    change = true;
                }else if (temp.getX() == movablePoints.get(j).getX()){
                    if (temp.getY() > movablePoints.get(j).getY()){
                        movablePoints.set(i, movablePoints.get(j));
                        movablePoints.set(j, temp);
                    }
                    change = true;
                }

            }
            if (!change){
                break;
            }
        }
        return movablePoints;
    }
}
