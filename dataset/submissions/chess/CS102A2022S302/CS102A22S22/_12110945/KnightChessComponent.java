import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

    private int x=super.getSource().getX();
    private int y=super.getSource().getY();
    private ChessComponent[][] targetN = super.getTarget();

    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ChessComponent[][] target){
        super(source, chessColor, name,target);

    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> KnightCanMoveTo =new ArrayList<>() ;
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j < 8; j++) {
                if (Math.abs(x-i)==1&&Math.abs(y-j)==2){
                    KnightCanMoveTo.add(new ChessboardPoint(i, j));
                    if (super.getChessColor() == targetN[i][j].getChessColor()) {
                        KnightCanMoveTo.remove(new ChessboardPoint(i, j));
                    }
                }
                if (Math.abs(x-i)==2&&Math.abs(y-j)==1){
                    KnightCanMoveTo.add(new ChessboardPoint(i, j));
                    if (super.getChessColor() == targetN[i][j].getChessColor()) {
                        KnightCanMoveTo.remove(new ChessboardPoint(i, j));
                    }
                }
            }
        }
        return KnightCanMoveTo;
    }
}

