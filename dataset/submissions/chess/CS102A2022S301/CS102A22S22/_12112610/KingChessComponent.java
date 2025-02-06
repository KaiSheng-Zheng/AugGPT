import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(char name, ChessColor chessColor, ChessboardPoint source,ChessComponent[][]chessComponents){
        super(name ,chessColor, source,chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        ChessboardPoint point = this.getSource();
        if (point.getX() - 1 >= 0) {
            if (chessboard[point.getX() - 1][point.getY()].getChessColor()!= this.getChessColor()) {
                result.add(point.offset(-1, 0));
            }
        }
        if (point.getY() - 1 >= 0) {
            if (chessboard[point.getX()][point.getY() - 1].getChessColor()!= this.getChessColor()) {
                result.add(point.offset(0, -1));
            }
        }
        if (point.getY() + 1 <= 7) {
            if (chessboard[point.getX()][point.getY() + 1].getChessColor()!= this.getChessColor()) {
                result.add(point.offset(0, 1));
            }
        }
        if (point.getX() + 1 <= 7) {
            if (chessboard[point.getX() + 1][point.getY()].getChessColor()!= this.getChessColor()) {
                result.add(point.offset(1, 0));
            }
        }
        if (point.getX() - 1 >= 0 && point.getY() + 1 <= 7) {
            if (chessboard[point.getX() - 1][point.getY() + 1].getChessColor() != this.getChessColor()) {
                result.add(point.offset(-1, 1));
            }
        }
        if (point.getX() + 1 <= 7 && point.getY() - 1 >= 0) {
            if (chessboard[point.getX() + 1][point.getY()- 1].getChessColor() != this.getChessColor()) {
                result.add(point.offset(1, -1));
            }
        }
        if (point.getX() + 1 <= 7 && point.getY() + 1 <= 7) {
            if (chessboard[point.getX() + 1][point.getY() + 1].getChessColor()!= this.getChessColor()) {
                result.add(point.offset(1, 1));
            }
        }
        if (point.getX() - 1 >= 0 && point.getY() - 1 >= 0) {
            if (chessboard[point.getX() - 1][point.getY() - 1].getChessColor() != this.getChessColor()) {
                result.add(point.offset(-1, -1));
            }
        }

        for (int i = 0; i < result.size(); i++) {
            for (int j = i + 1; j < result.size(); j++) {
                if (result.get(i).getX() > result.get(j).getX()) {
                    ChessboardPoint temp = result.get(i);
                    result.set(i, result.get(j));
                    result.set(j, temp);
                }
                else if (result.get(i).getX() == result.get(j).getX()) {
                    if (result.get(i).getY() > result.get(j).getY()) {
                        ChessboardPoint temp = result.get(i);
                        result.set(i, result.get(j));
                        result.set(j, temp);
                    }
                }
            }
        }
        return result;
    }
}




