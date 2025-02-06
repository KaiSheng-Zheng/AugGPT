import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor,char name) {
        this.name = name;
        setSource(chessboardPoint);
        setChessColor(chessColor);
    }

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> result = new ArrayList<>();
        ChessComponent[][] chessComponents = super.currentChessboard.getChessComponents();
        int[] x = new int[]{1,-1,0,0,1,1,-1,-1};
        int[] y = new int[]{0,0,1,-1,1,-1,1,-1};
        outerCycle:
        for (int i = 0; i < 8; i++) {
            int n = 1;
            while (this.getSource().offset(n * x[i] , n * y[i]) != null){
                if (chessComponents[super.getSource().getX() + n * x[i]][super.getSource().getY() + n * y[i]] instanceof EmptySlotComponent){
                    result.add(new ChessboardPoint(super.getSource().getX() + n * x[i],super.getSource().getY() + n * y[i]));
                }else{
                    result.add(new ChessboardPoint(super.getSource().getX() + n * x[i],super.getSource().getY() + n * y[i]));
                    break outerCycle;
                }
                n++;
            }
        }
        return result;
    }
}