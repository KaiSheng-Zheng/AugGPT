import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(int x,int y,ChessColor chessColor) {
        super(x,y,chessColor);
        if (chessColor == ChessColor.BLACK){
            name = 'Q';
        }else {
            name = 'q';
        }
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMove = new ArrayList<>();
        int y = super.getSource().getY();
        int x = super.getSource().getX();
        for (int i = 1; i <= x; i++) {
            if (y - i >= 0 && chessboard[x - i][y - i].toString().equals("_")) {
                canMove.add(new ChessboardPoint(x - i, y - i));
            } else if (y - i >= 0 && chessboard[x - i][y - i].getChessColor()!=this.getChessColor()){
                canMove.add(new ChessboardPoint(x - i, y - i));
                break;
            }else {
                break;
            }
        }
        for (int i = 1; i < 8 - x; i++) {
            if (y + i <= 7 && chessboard[x + i][y + i].toString().equals("_")) {
                canMove.add(new ChessboardPoint(x + i, y + i));
            } else if (y + i <= 7 && chessboard[x + i][y + i].getChessColor()!=this.getChessColor()){
                canMove.add(new ChessboardPoint(x + i, y + i));
                break;
            }else {
                break;
            }
        }
        for (int i = 1; i <= x; i++) {
            if (y + i <= 7 && chessboard[x - i][y + i].toString().equals("_")) {
                canMove.add(new ChessboardPoint(x - i, y + i));
            } else if (y + i <= 7 && chessboard[x - i][y + i].getChessColor()!=this.getChessColor()){
                canMove.add(new ChessboardPoint(x - i, y + i));
                break;
            }else {
                break;
            }
        }
        for (int i = 1; i < 8 - x; i++) {
            if (y - i >= 0 && chessboard[x + i][y - i].toString().equals("_")) {
                canMove.add(new ChessboardPoint(x + i, y - i));
            } else if (y - i >= 0 && chessboard[x + i][y - i].getChessColor()!=this.getChessColor()){
                canMove.add(new ChessboardPoint(x + i, y - i));
                break;
            }else {
                break;
            }
        }
        for (int i = 1; i <= x; i++) {
            if (chessboard[x - i][y].toString().equals("_")) {
                canMove.add(new ChessboardPoint(x - i, y));
            } else if (chessboard[x - i][y].getChessColor() != this.getChessColor()) {
                canMove.add(new ChessboardPoint(x - i, y));
                break;
            } else {
                break;
            }
        }
        for (int i = 1; i <= 7 - x; i++) {
            if (chessboard[x + i][y].toString().equals("_")) {
                canMove.add(new ChessboardPoint(x + i, y));
            } else if (chessboard[x + i][y].getChessColor() != this.getChessColor()) {
                canMove.add(new ChessboardPoint(x + i, y));
                break;
            } else {
                break;
            }
        }
        for (int i = 1; i <= y; i++) {
            if (chessboard[x][y - i].toString().equals("_")) {
                canMove.add(new ChessboardPoint(x, y - i));
            } else if (chessboard[x][y - i].getChessColor() != this.getChessColor()) {
                canMove.add(new ChessboardPoint(x, y - i));
                break;
            } else {
                break;
            }
        }
        for (int i = 1; i <= 7 - y; i++) {
            if (chessboard[x][y + i].toString().equals("_")) {
                canMove.add(new ChessboardPoint(x, y + i));
            } else if (chessboard[x][y + i].getChessColor() != this.getChessColor()) {
                canMove.add(new ChessboardPoint(x, y + i));
                break;
            } else {
                break;
            }
        }
        Collections.sort(canMove);
        return canMove;
    }
}
