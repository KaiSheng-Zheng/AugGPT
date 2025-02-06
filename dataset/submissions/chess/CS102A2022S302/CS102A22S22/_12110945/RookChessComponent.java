import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    private int x=super.getSource().getX();
    private int y=super.getSource().getY();
    private ChessComponent[][] targetR = super.getTarget();

    public RookChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ChessComponent[][] target){
        super(source, chessColor, name,target);

    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> RookCanMoveTo =new ArrayList<>() ;
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == x && y!=j ) {
                    RookCanMoveTo.add(new ChessboardPoint(i, j));
                    if (super.getChessColor() == targetR[i][j].getChessColor()) {
                        RookCanMoveTo.remove(new ChessboardPoint(i, j));
                    }
                    if (targetR[i][j].getChessColor()!=super.getChessColor() && y<j ) {
                        if (j==y+1){
                            RookCanMoveTo.remove(new ChessboardPoint(i, j));
                            RookCanMoveTo.add(new ChessboardPoint(i, j));
                        }
                        if (j!=y+1){
                            for (int k =y+1; k < j; k++) {
                            int same = 0; int opposite = 0;
                            if(targetR[i][k].getChessColor()==super.getChessColor()){
                                same = same +1;
                            }
                            if(targetR[i][k].getChessColor()!=ChessColor.NONE && targetR[i][k].getChessColor()!=super.getChessColor()){
                                opposite = opposite +1;
                            }
                            if (same != 0 ||opposite!=0 ){
                                RookCanMoveTo.remove(new ChessboardPoint(i, j));
                            }
                        }
                        }
                    }
                    if (targetR[i][j].getChessColor()!=super.getChessColor() && y>j){
                        if (j==y-1){
                            RookCanMoveTo.remove(new ChessboardPoint(i, j));
                            RookCanMoveTo.add(new ChessboardPoint(i, j));
                        }
                        if (j!=y-1){
                            for (int m = j+1 ; m<y ; m++){
                            int same = 0; int opposite = 0;
                            if (targetR[i][m].getChessColor()==super.getChessColor()){
                                same = same +1;
                            }
                            if(targetR[i][m].getChessColor()!=ChessColor.NONE && targetR[i][m].getChessColor()!=super.getChessColor()){
                                opposite = opposite +1;
                            }
                            if (same != 0 ||opposite!=0 ){
                                RookCanMoveTo.remove(new ChessboardPoint(i, j));
                            }
                        }
                        }
                    }
                }
                if ( j == y && x!= i) {
                    RookCanMoveTo.add(new ChessboardPoint(i, j));
                    if (super.getChessColor() == targetR[i][j].getChessColor()) {
                        RookCanMoveTo.remove(new ChessboardPoint(i, j));
                    }
                    if (targetR[i][j].getChessColor()!=super.getChessColor() && x<i ) {
                        if (i==x+1){
                            RookCanMoveTo.remove(new ChessboardPoint(i, j));
                            RookCanMoveTo.add(new ChessboardPoint(i, j));
                        }
                        if (i!=x+1){
                            for (int k = x+1; k < i; k++) {
                            int same = 0; int opposite = 0;
                            if(targetR[k][j].getChessColor()==super.getChessColor()){
                                same = same +1;
                            }
                            if(targetR[k][j].getChessColor()!=ChessColor.NONE && targetR[k][j].getChessColor()!=super.getChessColor()){
                                opposite = opposite +1;
                            }
                            if (same != 0 ||opposite!=0 ){
                                RookCanMoveTo.remove(new ChessboardPoint(i, j));
                            }
                        }
                        }
                    }
                    if (targetR[i][j].getChessColor()!=super.getChessColor() && x>i){
                        if (i==x-1){
                            RookCanMoveTo.remove(new ChessboardPoint(i, j));
                            RookCanMoveTo.add(new ChessboardPoint(i, j));
                        }
                        if (i!=x-1){
                            for (int m = i+1 ; m<x ; m++){
                                int same = 0; int opposite = 0;
                                if (targetR[m][j].getChessColor()==super.getChessColor()){
                                    same = same +1;
                                }
                                if(targetR[m][j].getChessColor()!=ChessColor.NONE && targetR[m][j].getChessColor()!=super.getChessColor()){
                                    opposite = opposite +1;
                                }
                                if (same != 0 ||opposite!=0 ){
                                    RookCanMoveTo.remove(new ChessboardPoint(i, j));
                                }
                            }
                        }
                    }
                }
            }
        }
        return RookCanMoveTo;
    }
}

