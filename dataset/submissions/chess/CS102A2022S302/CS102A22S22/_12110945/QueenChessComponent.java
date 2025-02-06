import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{

    private int x=super.getSource().getX();
    private int y=super.getSource().getY();
    private ChessComponent[][] targetQ = super.getTarget();

    public QueenChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ChessComponent[][] target){
        super(source, chessColor, name,target);

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> QueenCanMoveTo =new ArrayList<>() ;
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == x && y!=j  ) {
                    QueenCanMoveTo.add(new ChessboardPoint(i, j));
                    if (super.getChessColor() == targetQ[i][j].getChessColor()) {
                        QueenCanMoveTo.remove(new ChessboardPoint(i, j));
                    }
                    if (targetQ[i][j].getChessColor()!=super.getChessColor() && y<j ) {
                        if (j==y+1){
                            QueenCanMoveTo.remove(new ChessboardPoint(i, j));
                            QueenCanMoveTo.add(new ChessboardPoint(i, j));
                        }
                        if (j!=y+1){
                            for (int k =y+1; k < j; k++) {
                                int same = 0; int opposite = 0;
                                if(targetQ[i][k].getChessColor()==super.getChessColor()){
                                    same = same +1;
                                }
                                if(targetQ[i][k].getChessColor()!=ChessColor.NONE && targetQ[i][k].getChessColor()!=super.getChessColor()){
                                    opposite = opposite +1;
                                }
                                if (same != 0 ||opposite!=0 ){
                                    QueenCanMoveTo.remove(new ChessboardPoint(i, j));
                                }
                            }
                        }
                    }
                    if (targetQ[i][j].getChessColor()!=super.getChessColor() && y>j){
                        if (j==y-1){
                            QueenCanMoveTo.remove(new ChessboardPoint(i, j));
                            QueenCanMoveTo.add(new ChessboardPoint(i, j));
                        }
                        if (j!=y-1){
                            for (int m = j+1 ; m<y ; m++){
                                int same = 0; int opposite = 0;
                                if (targetQ[i][m].getChessColor()==super.getChessColor()){
                                    same = same +1;
                                }
                                if(targetQ[i][m].getChessColor()!=ChessColor.NONE && targetQ[i][m].getChessColor()!=super.getChessColor()){
                                    opposite = opposite +1;
                                }
                                if (same != 0 ||opposite!=0 ){
                                    QueenCanMoveTo.remove(new ChessboardPoint(i, j));
                                }
                            }
                        }
                    }
                }
                if ( j == y&& x!= i) {
                    QueenCanMoveTo.add(new ChessboardPoint(i, j));
                    if (super.getChessColor() == targetQ[i][j].getChessColor()) {
                        QueenCanMoveTo.remove(new ChessboardPoint(i, j));
                    }
                    if (targetQ[i][j].getChessColor()!=super.getChessColor() && x<i ) {
                        if (i==x+1){
                            QueenCanMoveTo.remove(new ChessboardPoint(i, j));
                            QueenCanMoveTo.add(new ChessboardPoint(i, j));
                        }
                        if (i!=x+1){
                            for (int k = x+1; k < i; k++) {
                                int same = 0; int opposite = 0;
                                if(targetQ[k][j].getChessColor()==super.getChessColor()){
                                    same = same +1;
                                }
                                if(targetQ[k][j].getChessColor()!=ChessColor.NONE && targetQ[k][j].getChessColor()!=super.getChessColor()){
                                    opposite = opposite +1;
                                }
                                if (same != 0 ||opposite!=0 ){
                                    QueenCanMoveTo.remove(new ChessboardPoint(i, j));
                                }
                            }
                        }
                    }
                    if (targetQ[i][j].getChessColor()!=super.getChessColor() && x>i){
                        if (i==x-1){
                            QueenCanMoveTo.remove(new ChessboardPoint(i, j));
                            QueenCanMoveTo.add(new ChessboardPoint(i, j));
                        }
                        if (i!=x-1){
                            for (int m = i+1 ; m<x ; m++){
                                int same = 0; int opposite = 0;
                                if (targetQ[m][j].getChessColor()==super.getChessColor()){
                                    same = same +1;
                                }
                                if(targetQ[m][j].getChessColor()!=ChessColor.NONE && targetQ[m][j].getChessColor()!=super.getChessColor()){
                                    opposite = opposite +1;
                                }
                                if (same != 0 ||opposite!=0 ){
                                    QueenCanMoveTo.remove(new ChessboardPoint(i, j));
                                }
                            }
                        }
                    }
                }
                if (Math.abs(x - i)==Math.abs(y - j)){
                    QueenCanMoveTo.add(new ChessboardPoint(i, j));
                    if (super.getChessColor() == targetQ[i][j].getChessColor()) {
                        QueenCanMoveTo.remove(new ChessboardPoint(i, j));
                    }
                    if (super.getChessColor() != targetQ[i][j].getChessColor()&& x<i&& y<j){
                        if ( i==x+1&&j==y+1){
                            QueenCanMoveTo.remove(new ChessboardPoint(i, j));
                            QueenCanMoveTo.add(new ChessboardPoint(i, j));
                        }
                        if (i!=x+1&&j!=y+1){
                            for (int k = x+1; k<i ;k++){
                                for (int m = y+1; m<j ;m++){
                                    int same = 0; int opposite = 0;
                                    if (targetQ[k][m].getChessColor()==super.getChessColor()){
                                        same = same +1;
                                    }
                                    if(targetQ[k][m].getChessColor()!=ChessColor.NONE && targetQ[i][k].getChessColor()!=super.getChessColor()){
                                        opposite = opposite +1;
                                    }
                                    if (same != 0 ||opposite!=0 ){
                                        QueenCanMoveTo.remove(new ChessboardPoint(i, j));
                                    }
                                }
                            }
                        }
                    }
                    if (super.getChessColor() != targetQ[i][j].getChessColor()&& x>i&& y>j){
                        if ( i==x-1&&j==y-1){
                            QueenCanMoveTo.remove(new ChessboardPoint(i, j));
                            QueenCanMoveTo.add(new ChessboardPoint(i, j));
                        }
                        if (i!=x-1&&j!=y-1){
                            for (int k = i+1; k<x ;k++){
                                for (int m = j+1; m<y ;m++){
                                    int same = 0; int opposite = 0;
                                    if (targetQ[k][m].getChessColor()==super.getChessColor()){
                                        same = same +1;
                                    }
                                    if(targetQ[k][m].getChessColor()!=ChessColor.NONE && targetQ[i][k].getChessColor()!=super.getChessColor()){
                                        opposite = opposite +1;
                                    }
                                    if (same != 0 ||opposite!=0 ){
                                        QueenCanMoveTo.remove(new ChessboardPoint(i, j));
                                    }
                                }
                            }
                        }
                    }
                    if (super.getChessColor() != targetQ[i][j].getChessColor()&& x>i&& y<j){
                        if ( i==x-1&&j==y+1){
                            QueenCanMoveTo.remove(new ChessboardPoint(i, j));
                            QueenCanMoveTo.add(new ChessboardPoint(i, j));
                        }
                        if (i!=x-1&&j!=y+1){
                            for (int k = i+1; k<x ;k++){
                                for (int m = j-1; m>y ;m--){
                                    int same = 0; int opposite = 0;
                                    if (targetQ[k][m].getChessColor()==super.getChessColor()){
                                        same = same +1;
                                    }
                                    if(targetQ[k][m].getChessColor()!=ChessColor.NONE && targetQ[i][k].getChessColor()!=super.getChessColor()){
                                        opposite = opposite +1;
                                    }
                                    if (same != 0 ||opposite!=0 ){
                                        QueenCanMoveTo.remove(new ChessboardPoint(i, j));
                                    }
                                }
                            }
                        }
                    }
                    if (super.getChessColor() != targetQ[i][j].getChessColor()&& x<i&& y>j){
                        if ( i==x+1&&j==y-1){
                            QueenCanMoveTo.remove(new ChessboardPoint(i, j));
                            QueenCanMoveTo.add(new ChessboardPoint(i, j));
                        }
                        if (i!=x+1&&j!=y-1){
                            for (int k = i-1; k>x ;k--){
                                for (int m = j+1; m<y ;m++){
                                    int same = 0; int opposite = 0;
                                    if (targetQ[k][m].getChessColor()==super.getChessColor()){
                                        same = same +1;
                                    }
                                    if(targetQ[k][m].getChessColor()!=ChessColor.NONE && targetQ[i][k].getChessColor()!=super.getChessColor()){
                                        opposite = opposite +1;
                                    }
                                    if (same != 0 ||opposite!=0 ){
                                        QueenCanMoveTo.remove(new ChessboardPoint(i, j));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return QueenCanMoveTo;
    }
}

