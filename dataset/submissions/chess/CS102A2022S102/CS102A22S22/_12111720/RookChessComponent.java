import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(char name) {
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> movablePoints = new ArrayList<>();
        int row = this.getSource().getX(), col = this.getSource().getY();
        for (int j = col + 1; j < 8; j++){
            if (getChessComponents()[row][j] instanceof EmptySlotComponent) {
                movablePoints.add(new ChessboardPoint(row, j));
            }else {
                if (getChessComponents()[row][j].getChessColor() != this.getChessColor()) {
                    movablePoints.add(new ChessboardPoint(row, j));
                    break;
                }
                break;

            }
        }
        for (int i = row, j = col - 1; j >= 0; j--){
            if (getChessComponents()[i][j] instanceof EmptySlotComponent) {
                movablePoints.add(new ChessboardPoint(i, j));
            }else {
                if (getChessComponents()[i][j].getChessColor() != this.getChessColor()) {
                    movablePoints.add(new ChessboardPoint(i, j));
                    break;
                }
                break;
            }
        }
        for (int i = row + 1, j = col; i < 8; i++){
            if (getChessComponents()[i][j] instanceof EmptySlotComponent) {
                movablePoints.add(new ChessboardPoint(i, j));
            }else {
                if (getChessComponents()[i][j].getChessColor() != this.getChessColor()) {
                    movablePoints.add(new ChessboardPoint(i, j));
                    break;
                }
                break;
            }
        }
        for (int i = row - 1, j = col; i >= 0; i--){
            if (getChessComponents()[i][j] instanceof EmptySlotComponent) {
                movablePoints.add(new ChessboardPoint(i, j));
            }else {
                if (getChessComponents()[i][j].getChessColor() != this.getChessColor()) {
                    movablePoints.add(new ChessboardPoint(i, j));
                    break;
                }
                break;
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
