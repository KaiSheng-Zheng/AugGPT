import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{

    public QueenChessComponent(ChessComponent[][] chessComponents, ChessboardPoint chessboardPoint) {
        this.chessComponents = chessComponents;
        setSource(chessboardPoint);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> QueenPoints = new ArrayList<>();
        int c1 =1, c2 = 1, c3 = 1, c4 = 1;
        int row = this.getSource().getX();
        int col = this.getSource().getY();
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
            QueenPoints.add(destination);
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
            QueenPoints.add(destination);
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
            QueenPoints.add(destination);
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
            QueenPoints.add(destination);
        }


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
            QueenPoints.add(destination);
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
            QueenPoints.add(destination);
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
            QueenPoints.add(destination);
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
            QueenPoints.add(destination);
        }
        return QueenPoints;
    }
}