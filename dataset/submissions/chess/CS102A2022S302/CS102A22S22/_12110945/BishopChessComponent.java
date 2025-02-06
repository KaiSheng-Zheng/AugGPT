import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{

    private int x=super.getSource().getX();
    private int y=super.getSource().getY();
    private ChessComponent[][] targetB = super.getTarget();

    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ChessComponent[][] target){
        super(source, chessColor, name,target);

    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> BishopCanMoveTo =new ArrayList<>() ;
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j < 8; j++) {
                if (Math.abs(x - i)==Math.abs(y - j)&& x!=i&& y!=j){
                    BishopCanMoveTo.add(new ChessboardPoint(i, j));
                    if (super.getChessColor() == targetB[i][j].getChessColor()) {
                        BishopCanMoveTo.remove(new ChessboardPoint(i, j));
                    }
                    if (super.getChessColor() != targetB[i][j].getChessColor()&& x<i&& y<j){
                        if ( i==x+1&&j==y+1){
                            BishopCanMoveTo.remove(new ChessboardPoint(i, j));
                            BishopCanMoveTo.add(new ChessboardPoint(i, j));
                        }
                        if (i!=x+1&&j!=y+1){
                            for (int k = x+1; k<i ;k++){
                            for (int m = y+1; m<j ;m++){
                                int same = 0; int opposite = 0;
                                if (targetB[k][m].getChessColor()==super.getChessColor()){
                                    same = same +1;
                                }
                                if(targetB[k][m].getChessColor()!=ChessColor.NONE && targetB[i][k].getChessColor()!=super.getChessColor()){
                                    opposite = opposite +1;
                                }
                                if (same != 0 ||opposite!=0 ){
                                    BishopCanMoveTo.remove(new ChessboardPoint(i, j));
                                }
                            }
                        }
                        }
                    }
                    if (super.getChessColor() != targetB[i][j].getChessColor()&& x>i&& y>j){
                        if ( i==x-1&&j==y-1){
                            BishopCanMoveTo.remove(new ChessboardPoint(i, j));
                            BishopCanMoveTo.add(new ChessboardPoint(i, j));
                        }
                        if (i!=x-1&&j!=y-1){
                            for (int k = i+1; k<x ;k++){
                            for (int m = j+1; m<y ;m++){
                                int same = 0; int opposite = 0;
                                if (targetB[k][m].getChessColor()==super.getChessColor()){
                                    same = same +1;
                                }
                                if(targetB[k][m].getChessColor()!=ChessColor.NONE && targetB[i][k].getChessColor()!=super.getChessColor()){
                                    opposite = opposite +1;
                                }
                                if (same != 0 ||opposite!=0 ){
                                    BishopCanMoveTo.remove(new ChessboardPoint(i, j));
                                }
                            }
                        }
                        }
                    }
                    if (super.getChessColor() != targetB[i][j].getChessColor()&& x>i&& y<j){
                        if ( i==x-1&&j==y+1){
                            BishopCanMoveTo.remove(new ChessboardPoint(i, j));
                            BishopCanMoveTo.add(new ChessboardPoint(i, j));
                        }
                        if (i!=x-1&&j!=y+1){
                            for (int k = i+1; k<x ;k++){
                                for (int m = j-1; m>y ;m--){
                                    int same = 0; int opposite = 0;
                                    if (targetB[k][m].getChessColor()==super.getChessColor()){
                                        same = same +1;
                                    }
                                    if(targetB[k][m].getChessColor()!=ChessColor.NONE && targetB[i][k].getChessColor()!=super.getChessColor()){
                                        opposite = opposite +1;
                                    }
                                    if (same != 0 ||opposite!=0 ){
                                        BishopCanMoveTo.remove(new ChessboardPoint(i, j));
                                    }
                                }
                            }
                        }
                    }
                    if (super.getChessColor() != targetB[i][j].getChessColor()&& x<i&& y>j){
                        if ( i==x+1&&j==y-1){
                            BishopCanMoveTo.remove(new ChessboardPoint(i, j));
                            BishopCanMoveTo.add(new ChessboardPoint(i, j));
                        }
                        if (i!=x+1&&j!=y-1){
                            for (int k = i-1; k>x ;k--){
                                for (int m = j+1; m<y ;m++){
                                    int same = 0; int opposite = 0;
                                    if (targetB[k][m].getChessColor()==super.getChessColor()){
                                        same = same +1;
                                    }
                                    if(targetB[k][m].getChessColor()!=ChessColor.NONE && targetB[i][k].getChessColor()!=super.getChessColor()){
                                        opposite = opposite +1;
                                    }
                                    if (same != 0 ||opposite!=0 ){
                                        BishopCanMoveTo.remove(new ChessboardPoint(i, j));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return BishopCanMoveTo;
    }
}

