import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> sc=new ArrayList<>();
        if(super.getSource().getX()<=6){
            for (int i = super.getSource().getX()+1; i <= 7; i++) {
                boolean is_toMove=true;
                if(super.getSource().getX()+1<i){
                    for (int j = super.getSource().getX()+1; j < i; j++) {
                        if (chessBoard[j][super.getSource().getY()].getName() != '_') {
                            is_toMove = false;
                            break;
                        }
                    }
                }
                if(chessBoard[i][super.getSource().getY()].getChessColor()!=super.getChessColor()&&is_toMove){
                    sc.add(new ChessboardPoint(i,super.getSource().getY()));
                }else {
                    break;
                }
            }
        }
        if(super.getSource().getX()>=1){
            for (int i = super.getSource().getX()-1; i >= 0; i--) {
                boolean is_toMove=true;
                if(super.getSource().getX()-1>i){
                    for (int j = super.getSource().getX()-1; j > i; j--) {
                        if (chessBoard[j][super.getSource().getY()].getName() != '_') {
                            is_toMove = false;
                            break;
                        }
                    }
                }
                if(chessBoard[i][super.getSource().getY()].getChessColor()!=super.getChessColor()&&is_toMove){
                    sc.add(new ChessboardPoint(i,super.getSource().getY()));
                }else {
                    break;
                }
            }
        }
        if(super.getSource().getY()<=6){
            for (int i = super.getSource().getY()+1; i <= 7; i++) {
                boolean is_toMove=true;
                if(super.getSource().getY()+1<i){
                    for (int j = super.getSource().getY()+1; j < i; j++) {
                        if (chessBoard[super.getSource().getX()][j].getName() != '_') {
                            is_toMove = false;
                            break;
                        }
                    }
                }
                if(chessBoard[super.getSource().getX()][i].getChessColor()!=super.getChessColor()&&is_toMove){
                    sc.add(new ChessboardPoint(super.getSource().getX(),i));
                }else {
                    break;
                }
            }
        }
        if(super.getSource().getY()>=1){
            for (int i = super.getSource().getY()-1; i >= 0; i--) {
                boolean is_toMove=true;
                if(super.getSource().getY()-1>i){
                    for (int j = super.getSource().getY()-1; j > i; j--) {
                        if (chessBoard[super.getSource().getX()][j].getName() != '_') {
                            is_toMove = false;
                            break;
                        }
                    }
                }
                if(chessBoard[super.getSource().getX()][i].getChessColor()!=super.getChessColor()&&is_toMove){
                    sc.add(new ChessboardPoint(super.getSource().getX(),i));
                }else {
                    break;
                }
            }
        }
        return sc;
    }
}
