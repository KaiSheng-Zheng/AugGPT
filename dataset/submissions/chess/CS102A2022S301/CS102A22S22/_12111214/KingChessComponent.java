import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
            super(source,chessColor,name);
    }

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> canMoveTo=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j <8 ; j++) {
                if (chessComponents[i][j].getChessColor() != this.getChessColor()) {
                    if (this.getSource().getY() == j) {
                        if (Math.abs(this.getSource().getX() - i) <= 1) {
                            canMoveTo.add(new ChessboardPoint(i, j));
                        }
                    } else if (this.getSource().getX() == i) {
                        if (Math.abs(this.getSource().getY() - j) <= 1) {
                            canMoveTo.add(new ChessboardPoint(i, j));
                        }
                    } else if (Math.abs(this.getSource().getX() - i) == 1 && Math.abs(this.getSource().getY() - j) == 1) {
                        canMoveTo.add(new ChessboardPoint(i, j));
                    }
                }
            }
        }
        return canMoveTo;
    }
}