import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent() {}

    @Override
    public List<ChessboardPoint> canMoveTo() {
        boolean canMove = true;
        ChessboardPoint source = getSource();
        List<ChessboardPoint> can = new ArrayList<>();
        int row = source.getX();
        int col = source.getY();
        for (int i = row+1; i < 8; i++) {
            canMove = true;
            ChessboardPoint destination1 = new ChessboardPoint(i, col);
            for (int j = row+1; j <i ; j++) {
                if (!(chessboard[j][col] instanceof EmptySlotComponent)) {
                    canMove = false;
                }
            }
                if (canMove&&chessboard[i][col].chessColor==getChessColor()){
                    canMove =false;
                }
                if (source.getX()==destination1.getX()&&source.getY()==destination1.getY()){
                canMove=false;
            }
            if (canMove ==true){
                can.add(destination1);
            }
        }
        for (int i = row-1; i >= 0; i--) {
            canMove = true;
            ChessboardPoint destination1 = new ChessboardPoint(i, col);
            for (int j = row-1; j >i ; j--) {
                if (!(chessboard[j][col] instanceof EmptySlotComponent)) {
                    canMove = false;
                }
            }
                    if (canMove&&chessboard[i][col].chessColor==getChessColor()){
                        canMove =false;
                    }
                    if (source.getX()==destination1.getX()&&source.getY()==destination1.getY()){
                canMove=false;
            }
            if (canMove ==true){
                can.add(destination1);
            }

        }
        for (int i =col-1; i >= 0; i--) {
            canMove = true;
            ChessboardPoint destination = new ChessboardPoint(row, i);
            for (int j = col-1; j >i ; j--) {
                if (!(chessboard[row][j] instanceof EmptySlotComponent)) {
                    canMove = false;
                }
            }
                if (canMove&&chessboard[row][i].chessColor==getChessColor()){
                    canMove =false;
                }
            if (source.getX()==destination.getX()&&source.getY()==destination.getY()){
                canMove=false;
            }
            if (canMove ==true){
                can.add(destination);
            }
        }
        for (int i =col+1; i < 8; i++) {
            canMove = true;
            ChessboardPoint destination = new ChessboardPoint(row, i);
            for (int j = col+1; j <i ; j++) {
                if (!(chessboard[row][j] instanceof EmptySlotComponent)) {
                    canMove = false;
                }
            }
                if (canMove&&chessboard[row][i].chessColor==getChessColor()){
                    canMove =false;
                }
            if (source.getX()==destination.getX()&&source.getY()==destination.getY()){
                canMove=false;
            }
            if (canMove ==true){
                can.add(destination);
            }

        }

        if (can != null) {
            return can;
        } else {
            return new ArrayList<>();
        }
    }
}
