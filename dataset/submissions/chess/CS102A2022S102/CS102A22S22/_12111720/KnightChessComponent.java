import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(char name) {
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> movablePoints = new ArrayList<>();
        int row = this.getSource().getX(), col = this.getSource().getY();
        if (row - 1 >= 0) {
            if (col - 2 >= 0) {
                if (getChessComponents()[row - 1][col - 2].getChessColor() != this.getChessColor()) {
                    movablePoints.add(new ChessboardPoint(row - 1, col - 2));
                }
            }
            if (col + 2 < 8) {
                if (getChessComponents()[row - 1][col + 2].getChessColor() != this.getChessColor()) {
                    movablePoints.add(new ChessboardPoint(row - 1, col + 2));
                }
            }
        }
        if (row + 1 < 8) {
            if (col - 2 >= 0) {
                if (getChessComponents()[row + 1][col - 2].getChessColor() != this.getChessColor()) {
                    movablePoints.add(new ChessboardPoint(row + 1, col - 2));
                }
            }
            if (col + 2 < 8) {
                if (getChessComponents()[row + 1][col + 2].getChessColor() != this.getChessColor()) {
                    movablePoints.add(new ChessboardPoint(row + 1, col + 2));
                }
            }
        }
        if (row - 2 >= 0) {
            if (col - 1 >= 0) {
                if (getChessComponents()[row - 2][col - 1].getChessColor() != this.getChessColor()) {
                    movablePoints.add(new ChessboardPoint(row - 2, col - 1));
                }
            }
            if (col + 1 < 8) {
                if (getChessComponents()[row - 2][col + 1].getChessColor() != this.getChessColor()) {
                    movablePoints.add(new ChessboardPoint(row - 2, col + 1));
                }
            }
        }
        if (row + 2 < 8) {
            if (col - 1 >= 0) {
                if (getChessComponents()[row + 2][col - 1].getChessColor() != this.getChessColor()) {
                    movablePoints.add(new ChessboardPoint(row + 2, col - 1));
                }
            }
            if (col + 1 < 8) {
                if (getChessComponents()[row + 2][col + 1].getChessColor() != this.getChessColor()) {
                    movablePoints.add(new ChessboardPoint(row + 2, col + 1));
                }
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
