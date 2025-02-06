import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{

    public BishopChessComponent(ChessComponent[][] chessComponents, ChessboardPoint chessboardPoint) {
        this.chessComponents = chessComponents;
        setSource(chessboardPoint);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> BishopPoints = new ArrayList<>();
        int row = this.getSource().getX();
        int col = this.getSource().getY();
        int c1 =1, c2 = 1, c3 = 1, c4 = 1;
        for (int i = 1; row - i >= 0 && col - i >= 0; i++){
            c1 = i;
            if (!(chessComponents[row - i][col - i] instanceof EmptySlotComponent)){
                break;
            }
        }
        if (row - c1 >= 0 && col - c1 >= 0){
            if (chessComponents[row - c1][col - c1].getChessColor() == this.getChessColor()){
                c1 -= 1;
            }
        }else {
            c1 = 0;
        }
        for (int i = 1; i <= c1; i++){
            ChessboardPoint destination = new ChessboardPoint(row - i, col - i);
            BishopPoints.add(destination);
        }


        for (int i = 1; row + i <= 7 && col + i <= 7; i++){
            c2 = i;
            if (!(chessComponents[row + i][col + i] instanceof EmptySlotComponent)){
                break;
            }
        }
        if (row != 7 && col != 7) {
            if (chessComponents[row + c2][col + c2].getChessColor() == this.getChessColor()) {
                c2 -= 1;
            }
        }else {
            c2 = 0;
        }
        for (int i = 1; i <= c2; i++){
            ChessboardPoint destination = new ChessboardPoint(row + i, col + i);
            BishopPoints.add(destination);
        }

        for (int j = 1; row - j >= 0 && col + j <= 7; j++){
            c3 = j;
            if (!(chessComponents[row - j][col + j] instanceof EmptySlotComponent)){
                break;
            }
        }
        if (row - c3 >= 0 && col + c3 <= 7) {
            if (chessComponents[row - c3][col + c3].getChessColor() == this.getChessColor()) {
                c3 -= 1;
            }
        } else {
            c3 = 0;
        }
        for (int j = 1; j <= c3; j++){
            ChessboardPoint destination = new ChessboardPoint(row - j, col + j);
            BishopPoints.add(destination);
        }


        for (int j = 1; row + j < 8 && col - j >= 0; j++){
            c4 = j;
            if (!(chessComponents[row + j][col - j] instanceof EmptySlotComponent)){
                break;
            }
        }
        if (row + c4 <= 7 && col - c4 >= 0) {
            if (chessComponents[row + c4][col - c4].getChessColor() == this.getChessColor()) {
                c4 -= 1;
            }
        }else {
            c4 = 0;
        }
        for (int j = 1; j <= c4; j++){
            ChessboardPoint destination = new ChessboardPoint(row + j, col - j);
            BishopPoints.add(destination);
        }
        return BishopPoints;
    }
}
