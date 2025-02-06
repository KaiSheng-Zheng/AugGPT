import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> sc=new ArrayList<>();
        for (int i = 1; i < 8 ; i++) {
            boolean is_toMove=true;
            if(1<i){
                for (int j = 1; j < i; j++) {
                    if(!(super.getSource().getX()-j>=0&&super.getSource().getX()-j<=7&&super.getSource().getY()-j>=0&&super.getSource().getY()-j<=7)){
                        is_toMove = false;
                        break;
                    }
                    if (chessBoard[super.getSource().getX()-j][super.getSource().getY()-j].getName() != '_') {
                        is_toMove = false;
                        break;
                    }
                }
            }
            if(super.getSource().getX()-i>=0&&super.getSource().getX()-i<=7&&super.getSource().getY()-i>=0&&super.getSource().getY()-i<=7&&chessBoard[super.getSource().getX()-i][super.getSource().getY()-i].getChessColor()!=super.getChessColor()&&is_toMove){
                sc.add(new ChessboardPoint(super.getSource().getX()-i,super.getSource().getY()-i));
            }else {
                break;
            }
        }
        for (int i = 1; i < 8 ; i++) {
            boolean is_toMove=true;
            if(1<i){
                for (int j = 1; j < i; j++) {
                    if(!(super.getSource().getX()+j>=0&&super.getSource().getX()+j<=7&&super.getSource().getY()+j>=0&&super.getSource().getY()+j<=7)){
                        is_toMove = false;
                        break;
                    }
                    if (chessBoard[super.getSource().getX()+j][super.getSource().getY()+j].getName() != '_') {
                        is_toMove = false;
                        break;
                    }
                }
            }
            if(super.getSource().getX()+i>=0&&super.getSource().getX()+i<=7&&super.getSource().getY()+i>=0&&super.getSource().getY()+i<=7&&chessBoard[super.getSource().getX()+i][super.getSource().getY()+i].getChessColor()!=super.getChessColor()&&is_toMove){
                sc.add(new ChessboardPoint(super.getSource().getX()+i,super.getSource().getY()+i));
            }else {
                break;
            }
        }
        for (int i = 1; i < 8 ; i++) {
            boolean is_toMove=true;
            if(1<i){
                for (int j = 1; j < i; j++) {
                    if(!(super.getSource().getX()-j>=0&&super.getSource().getX()-j<=7&&super.getSource().getY()+j>=0&&super.getSource().getY()+j<=7)){
                        is_toMove = false;
                        break;
                    }
                    if (chessBoard[super.getSource().getX()-j][super.getSource().getY()+j].getName() != '_') {
                        is_toMove = false;
                        break;
                    }
                }
            }
            if(super.getSource().getX()-i>=0&&super.getSource().getX()-i<=7&&super.getSource().getY()+i>=0&&super.getSource().getY()+i<=7&&chessBoard[super.getSource().getX()-i][super.getSource().getY()+i].getChessColor()!=super.getChessColor()&&is_toMove){
                sc.add(new ChessboardPoint(super.getSource().getX()-i,super.getSource().getY()+i));
            }else {
                break;
            }
        }
        for (int i = 1; i < 8 ; i++) {
            boolean is_toMove=true;
            if(1<i){
                for (int j = 1; j < i; j++) {
                    if(!(super.getSource().getX()+j>=0&&super.getSource().getX()+j<=7&&super.getSource().getY()-j>=0&&super.getSource().getY()-j<=7)){
                        is_toMove = false;
                        break;
                    }
                    if (chessBoard[super.getSource().getX()+j][super.getSource().getY()-j].getName() != '_') {
                        is_toMove = false;
                        break;
                    }
                }
            }
            if(super.getSource().getX()+i>=0&&super.getSource().getX()+i<=7&&super.getSource().getY()-i>=0&&super.getSource().getY()-i<=7&&chessBoard[super.getSource().getX()+i][super.getSource().getY()-i].getChessColor()!=super.getChessColor()&&is_toMove){
                sc.add(new ChessboardPoint(super.getSource().getX()+i,super.getSource().getY()-i));
            }else {
                break;
            }
        }
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
