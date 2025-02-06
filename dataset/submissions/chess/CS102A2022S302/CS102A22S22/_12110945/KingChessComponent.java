import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private int x=super.getSource().getX();
    private int y=super.getSource().getY();
    private ChessComponent[][] targetK = super.getTarget();
    //ChessComponent[][] targetK =  ;
    public KingChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ChessComponent[][] target){
        super(source, chessColor, name, target);

    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> KingCanMoveTo =new ArrayList<>() ;
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8 ; j++) {
                if (Math.abs(x-i)==1&&Math.abs(y-j)==1){
                    KingCanMoveTo.add(new ChessboardPoint(i,j));
                    if(super.getChessColor()==targetK[i][j].getChessColor()){
                        KingCanMoveTo.remove(new ChessboardPoint(i,j));
                   }
                }
                if (Math.abs(x-i)==1&&y==j){
                    KingCanMoveTo.add(new ChessboardPoint(i,j));
                    if(super.getChessColor()==targetK[i][j].getChessColor()){
                        KingCanMoveTo.remove(new ChessboardPoint(i,j));
                    }
                }
                if (x==i&&Math.abs(y-j)==1){
                    KingCanMoveTo.add(new ChessboardPoint(i,j));
                    if(super.getChessColor()==targetK[i][j].getChessColor()){
                        KingCanMoveTo.remove(new ChessboardPoint(i,j));
                    }
                }
            }
        }
        return KingCanMoveTo;
    }
}
