import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        super(source, chessColor, name);
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> canMoveTo=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            a:for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getChessColor() != this.getChessColor()) {
                    if (Math.abs(this.getSource().getX() - i) == Math.abs(this.getSource().getY() - j)) {
                        int signDetaX, signDetaY;
                        if (i >= this.getSource().getX()) {
                            signDetaX = 1;
                        } else {
                            signDetaX = -1;
                        }
                        if (j >= this.getSource().getY()) {
                            signDetaY = 1;
                        } else {
                            signDetaY = -1;
                        }
                        for (int k = 1; k < Math.abs(this.getSource().getX() - i); k++) {
                            if (!(super.chessComponents[this.getSource().getX() + signDetaX * k][this.getSource().getY() + signDetaY * k] instanceof EmptySlotComponent)) {
                                continue a;
                            }
                        }
                    } else {
                        continue;
                    }
                    canMoveTo.add(new ChessboardPoint(i, j));
                }
            }
        }
        return canMoveTo;
    }
}
