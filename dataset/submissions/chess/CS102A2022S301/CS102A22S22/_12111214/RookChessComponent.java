import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
            super(source, chessColor, name);
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> canMoveTo;
        canMoveTo=new ArrayList<>(){};
        for (int i = 0; i < 8; i++) {
           a: for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getChessColor() != this.getChessColor()) {
                    if (this.getSource().getX() == i) {
                        int row = this.getSource().getX();
                        for (int col = Math.min(this.getSource().getY(), j) + 1;
                             col < Math.max(this.getSource().getY(), j); col++) {
                            if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                                continue a;
                            }
                        }
                    } else if (this.getSource().getY() == j) {
                        int col = this.getSource().getY();
                        for (int row = Math.min(this.getSource().getX(), i) + 1;
                             row < Math.max(this.getSource().getX(), i); row++) {
                            if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                                continue a;
                            }
                        }
                    } else { // Not on the same row or the same column.
                        continue;
                    }
                    canMoveTo.add(new ChessboardPoint(i, j));
                }
            }
        }
        return canMoveTo;
    }
}
