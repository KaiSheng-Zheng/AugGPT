import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor,char name) {
        this.name = name;
        setSource(chessboardPoint);
        setChessColor(chessColor);
    }

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> result = new ArrayList<>();
        ChessComponent[][] chessComponents = super.currentChessboard.getChessComponents();
        int[] x = new int[]{2,2,1,1,-1,-1,-2,-2};
        int[] y = new int[]{1,-1,2,-2,2,-2,1,-1};
        outerCycle:
        for (int i = 0; i < 8; i++) {
            while (this.getSource().offset(x[i] , y[i]) != null){
                if (chessComponents[super.getSource().getX() + x[i]][super.getSource().getY() + y[i]] instanceof EmptySlotComponent){
                    result.add(new ChessboardPoint(super.getSource().getX() + x[i],super.getSource().getY() + y[i]));
                }else{
                    result.add(new ChessboardPoint(super.getSource().getX() + x[i],super.getSource().getY() + y[i]));
                    break outerCycle;
                }
            }
        }
        return result;
    }
}