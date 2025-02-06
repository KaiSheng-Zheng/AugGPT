import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        for (int i = 1;i<8;i++) {
            if (x + i < 8 && y + i < 8) {
                if (whetherhava(x + i, y + i)) {
                    chessboardPoints.add(new ChessboardPoint(x + i, y + i));
                } else if (getChessColor() != getChessComponents()[x + i][y + i].getChessColor()) {
                    chessboardPoints.add(new ChessboardPoint(x + i, y + i));
                    break;
                }else {
                    break;
                }
            }
        }
        for (int i = 1;i<8;i++) {
            if (x + i < 8 && y - i >= 0) {
                if (whetherhava(x + i, y - i)) {
                    chessboardPoints.add(new ChessboardPoint(x + i, y - i));
                } else if (getChessColor() != getChessComponents()[x + i][y - i].getChessColor()) {
                    chessboardPoints.add(new ChessboardPoint(x + i, y - i));
                    break;
                }else {
                    break;
                }
            }
        }
        for (int i = 1;i<8;i++) {
            if (x - i >= 0 && y + i < 8) {
                if (whetherhava(x - i, y + i)) {
                    chessboardPoints.add(new ChessboardPoint(x - i, y + i));
                } else if (getChessColor() != getChessComponents()[x - i][y + i].getChessColor()) {
                    chessboardPoints.add(new ChessboardPoint(x - i, y + i));
                    break;
                }else {
                    break;
                }
            }
        }
        for (int i = 1;i<8;i++) {
            if(x-i>=0 && y-i>=0){
                if (whetherhava(x-i,y-i)){
                    chessboardPoints.add(new ChessboardPoint(x-i,y-i));
                }else if (getChessColor() != getChessComponents()[x-i][y-i].getChessColor()){
                    chessboardPoints.add(new ChessboardPoint(x-i,y-i));
                    break;
                }else {
                    break;
                }
            }
        }
        return chessboardPoints;
    }
}
