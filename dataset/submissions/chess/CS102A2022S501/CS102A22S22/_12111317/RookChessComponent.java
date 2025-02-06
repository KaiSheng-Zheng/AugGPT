import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessComponent[][] chessComponents, ChessboardPoint chessboardPoint) {
        this.chessComponents = chessComponents;
        setSource(chessboardPoint);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> RookPoints = new ArrayList<>();
        int row = this.getSource().getX();
        int col = this.getSource().getY();
        int c1 =1, c2 = 1, c3 = 1, c4 = 1;
        for (int i = row - 1; i >= 0; i--){
            c1 = i;
            if (!(chessComponents[i][col] instanceof EmptySlotComponent)){
                break;
            }
        }
        if (row - c1 >= 0) {
            if (chessComponents[c1][col].getChessColor() == this.getChessColor()) {
                c1 += 1;
            }
        }else {
            c1 = 0;
        }
        for (int i = c1; i < row; i++){
            ChessboardPoint destination = new ChessboardPoint(i, col);
            RookPoints.add(destination);
        }


        for (int i = row + 1; i < 8; i++){
            c2 = i;
            if (!(chessComponents[i][col] instanceof EmptySlotComponent)){
                break;
            }
        }
        if (c2 > row) {
            if (chessComponents[c2][col].getChessColor() == this.getChessColor()) {
                c2 -= 1;
            }
        }else {
            c2 = 0;
        }
        for (int i = row + 1; i <= c2; i++){
            ChessboardPoint destination = new ChessboardPoint(i, col);
            RookPoints.add(destination);
        }


        for (int j = col - 1; j >= 0; j--){
            c3 = j;
            if (!(chessComponents[row][j] instanceof EmptySlotComponent)){
                break;
            }
        }
        if (col - c3 >= 0) {
            if (chessComponents[row][c3].getChessColor() == this.getChessColor()) {
                c3 += 1;
            }
        }else {
            c3 = 0;
        }
        for (int j = c3; j < col; j++){
            ChessboardPoint destination = new ChessboardPoint(row, j);
            RookPoints.add(destination);
        }


        for (int j = col + 1; j < 8; j++){
            c4 = j;
            if (!(chessComponents[row][j] instanceof EmptySlotComponent)){
                break;
            }
        }
        if (c4 > col) {
            if (chessComponents[row][c4].getChessColor() == this.getChessColor()) {
                c4 -= 1;
            }
        }else {
            c4 = 0;
        }
        for (int j = col + 1; j <= c4; j++){
            ChessboardPoint destination = new ChessboardPoint(row, j);
            RookPoints.add(destination);
        }
        return RookPoints;
    }
}
