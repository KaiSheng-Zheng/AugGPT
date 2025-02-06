import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] now) {
        setSource(source);
        setChessColor(chessColor);
        setName(name);
        setNow(now);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canChessMove = new ArrayList<>();

        if (getSource().getX()-1>=0 && getSource().getX()-1<=7 && getSource().getY()-1>=0 && getSource().getY()-1<=7
                && getNow()[getSource().getX()-1][getSource().getY()-1].getChessColor() != getChessColor()){
            canChessMove.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
        }

        if (getSource().getX()-1>=0 && getSource().getX()-1<=7 && getSource().getY()>=0 && getSource().getY()<=7
                && getNow()[getSource().getX()-1][getSource().getY()].getChessColor() != getChessColor()){
            canChessMove.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()));
        }

        if (getSource().getX()-1>=0 && getSource().getX()-1<=7 && getSource().getY()+1>=0 && getSource().getY()+1<=7
                && getNow()[getSource().getX()-1][getSource().getY()+1].getChessColor() != getChessColor()){
            canChessMove.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
        }

        if (getSource().getX()>=0 && getSource().getX()<=7 && getSource().getY()+1>=0 && getSource().getY()+1<=7
                && getNow()[getSource().getX()][getSource().getY()+1].getChessColor() != getChessColor()){
            canChessMove.add(new ChessboardPoint(getSource().getX(),getSource().getY()+1));
        }

        if (getSource().getX()>=0 && getSource().getX()<=7 && getSource().getY()-1>=0 && getSource().getY()-1<=7
                && getNow()[getSource().getX()][getSource().getY()-1].getChessColor() != getChessColor()){
            canChessMove.add(new ChessboardPoint(getSource().getX(),getSource().getY()-1));
        }

        if (getSource().getX()+1>=0 && getSource().getX()+1<=7 && getSource().getY()-1>=0 && getSource().getY()-1<=7
                && getNow()[getSource().getX()+1][getSource().getY()-1].getChessColor() != getChessColor()){
            canChessMove.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));
        }

        if (getSource().getX()+1>=0 && getSource().getX()+1<=7 && getSource().getY()>=0 && getSource().getY()<=7
                && getNow()[getSource().getX()+1][getSource().getY()].getChessColor() != getChessColor()){
            canChessMove.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()));
        }

        if (getSource().getX()+1>=0 && getSource().getX()+1<=7 && getSource().getY()+1>=0 && getSource().getY()+1<=7
                && getNow()[getSource().getX()+1][getSource().getY()+1].getChessColor() != getChessColor()){
            canChessMove.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
        }


//        ArrayList<ChessboardPoint> noMove = new ArrayList<>();
//        if (getChessColor() == ChessColor.WHITE){
//            for (int i = 0; i < 8; i++) {
//                for (int j = 0; j < 8; j++) {
//                    if (getNow()[i][j].getChessColor() == ChessColor.BLACK && getNow()[i][j].getName() != 'K'){
//                        noMove.addAll(getNow()[i][j].canMoveTo());
//                    }
//                }
//            }
//
//            if (getSource().getX()-1>=0 && getSource().getX()-1<=7 && getSource().getY()-1>=0 && getSource().getY()-1<=7
//                && getNow()[getSource().getX()-1][getSource().getY()-1].getChessColor() != getChessColor()){
//                int a = 0;
//                for (int i = 0; i < noMove.size(); i++) {
//                    if (getSource().getX()-1 == noMove.get(i).getX() && getSource().getY()-1 == noMove.get(i).getY()){
//                        a++;
//                        break;
//                    }
//                }
//                if (a == 0){
//                    canChessMove.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
//                }
//            }
//
//            if (getSource().getX()-1>=0 && getSource().getX()-1<=7 && getSource().getY()>=0 && getSource().getY()<=7
//                && getNow()[getSource().getX()-1][getSource().getY()].getChessColor() != getChessColor()){
//                int a = 0;
//                for (int i = 0; i < noMove.size(); i++) {
//                    if (getSource().getX()-1 == noMove.get(i).getX() && getSource().getY() == noMove.get(i).getY()){
//                        a++;
//                        break;
//                    }
//                }
//                if (a == 0){
//                    canChessMove.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()));
//                }
//            }
//
//            if (getSource().getX()-1>=0 && getSource().getX()-1<=7 && getSource().getY()+1>=0 && getSource().getY()+1<=7
//                && getNow()[getSource().getX()-1][getSource().getY()+1].getChessColor() != getChessColor()){
//                int a = 0;
//                for (int i = 0; i < noMove.size(); i++) {
//                    if (getSource().getX()-1 == noMove.get(i).getX() && getSource().getY()+1 == noMove.get(i).getY()){
//                        a++;
//                        break;
//                    }
//                }
//                if (a == 0){
//                    canChessMove.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
//                }
//            }
//
//            if (getSource().getX()>=0 && getSource().getX()<=7 && getSource().getY()-1>=0 && getSource().getY()-1<=7
//                && getNow()[getSource().getX()][getSource().getY()-1].getChessColor() != getChessColor()){
//                int a = 0;
//                for (int i = 0; i < noMove.size(); i++) {
//                    if (getSource().getX() == noMove.get(i).getX() && getSource().getY()-1 == noMove.get(i).getY()){
//                        a++;
//                        break;
//                    }
//                }
//                if (a == 0){
//                    canChessMove.add(new ChessboardPoint(getSource().getX(),getSource().getY()-1));
//                }
//            }
//
//            if (getSource().getX()>=0 && getSource().getX()<=7 && getSource().getY()+1>=0 && getSource().getY()+1<=7
//                && getNow()[getSource().getX()][getSource().getY()+1].getChessColor() != getChessColor()){
//                int a = 0;
//                for (int i = 0; i < noMove.size(); i++) {
//                    if (getSource().getX() == noMove.get(i).getX() && getSource().getY()+1 == noMove.get(i).getY()){
//                        a++;
//                        break;
//                    }
//                }
//                if (a == 0){
//                    canChessMove.add(new ChessboardPoint(getSource().getX(),getSource().getY()+1));
//                }
//            }
//
//            if (getSource().getX()+1>=0 && getSource().getX()+1<=7 && getSource().getY()-1>=0 && getSource().getY()-1<=7
//                && getNow()[getSource().getX()+1][getSource().getY()-1].getChessColor() != getChessColor()){
//                int a = 0;
//                for (int i = 0; i < noMove.size(); i++) {
//                    if (getSource().getX()+1 == noMove.get(i).getX() && getSource().getY()-1 == noMove.get(i).getY()){
//                        a++;
//                        break;
//                    }
//                }
//                if (a == 0){
//                    canChessMove.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));
//                }
//            }
//
//            if (getSource().getX()+1>=0 && getSource().getX()+1<=7 && getSource().getY()>=0 && getSource().getY()<=7
//                && getNow()[getSource().getX()+1][getSource().getY()].getChessColor() != getChessColor()){
//                int a = 0;
//                for (int i = 0; i < noMove.size(); i++) {
//                    if (getSource().getX()+1 == noMove.get(i).getX() && getSource().getY() == noMove.get(i).getY()){
//                        a++;
//                        break;
//                    }
//                }
//                if (a == 0){
//                    canChessMove.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()));
//                }
//            }
//
//            if (getSource().getX()+1>=0 && getSource().getX()+1<=7 && getSource().getY()+1>=0 && getSource().getY()+1<=7
//                && getNow()[getSource().getX()+1][getSource().getY()+1].getChessColor() != getChessColor()){
//                int a = 0;
//                for (int i = 0; i < noMove.size(); i++) {
//                    if (getSource().getX()+1 == noMove.get(i).getX() && getSource().getY()+1 == noMove.get(i).getY()){
//                        a++;
//                        break;
//                    }
//                }
//                if (a == 0){
//                    canChessMove.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
//                }
//            }
//
//            int x = 0, y = 0;
//            for (int i = 0; i < 8; i++) {
//                for (int j = 0; j < 8; j++) {
//                    if (getNow()[i][j].getName() == 'K'){
//                        x = i;
//                        y = j;
//                    }
//                }
//            }
//
//            if (Math.abs(getSource().getX()-x) == 2 || Math.abs(getSource().getY()-y) == 2){
//                if (getSource().getX() - x == 2){
//                    if (getSource().getY()-y == -2){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
//                    }
//
//                    if (getSource().getY()-y == -1){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()-1,getSource().getY()));
//                    }
//
//                    if (getSource().getY() == y){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()-1,getSource().getY()));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
//                    }
//
//                    if (getSource().getY()-y == 1){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()-1,getSource().getY()));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
//                    }
//
//                    if (getSource().getY()-y == 2){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
//                    }
//                }
//
//                if (getSource().getX() - x == 1){
//                    if (getSource().getY()-y == -2){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX(),getSource().getY()+1));
//                    }
//                    if (getSource().getY()-y == 2){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX(),getSource().getY()-1));
//                    }
//                }
//
//                if (getSource().getX() == x){
//                    if (getSource().getY()-y == -2){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX(),getSource().getY()+1));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
//                    }
//                    if (getSource().getY()-y == 2){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX(),getSource().getY()-1));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));
//                    }
//                }
//
//                if (getSource().getX()-x == -1){
//                    if (getSource().getY()-y == -2){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX(),getSource().getY()+1));
//                    }
//                    if (getSource().getY()-y == 2){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX(),getSource().getY()-1));
//                    }
//                }
//
//                if (getSource().getX()-x == -2){
//                    if (getSource().getY()-y == -2){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
//                    }
//
//                    if (getSource().getY()-y == -1){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()+1,getSource().getY()));
//                    }
//
//                    if (getSource().getY() == y){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()+1,getSource().getY()));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));
//                    }
//
//                    if (getSource().getY()-y == 1){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()+1,getSource().getY()));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));
//                    }
//
//                    if (getSource().getY()-y == 2){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));
//                    }
//                }
//            }
//        }else{
//            for (int i = 0; i < 8; i++) {
//                for (int j = 0; j < 8; j++) {
//                    if (getNow()[i][j].getChessColor() == ChessColor.WHITE && getNow()[i][j].getName() != 'k'){
//                        noMove.addAll(getNow()[i][j].canMoveTo());
//                    }
//                }
//            }
//
//            if (getSource().getX()-1>=0 && getSource().getX()-1<=7 && getSource().getY()-1>=0 && getSource().getY()-1<=7
//                    && getNow()[getSource().getX()-1][getSource().getY()-1].getChessColor() != getChessColor()){
//                int a = 0;
//                for (int i = 0; i < noMove.size(); i++) {
//                    if (getSource().getX()-1 == noMove.get(i).getX() && getSource().getY()-1 == noMove.get(i).getY()){
//                        a++;
//                        break;
//                    }
//                }
//                if (a == 0){
//                    canChessMove.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
//                }
//            }
//
//            if (getSource().getX()-1>=0 && getSource().getX()-1<=7 && getSource().getY()>=0 && getSource().getY()<=7
//                    && getNow()[getSource().getX()-1][getSource().getY()].getChessColor() != getChessColor()){
//                int a = 0;
//                for (int i = 0; i < noMove.size(); i++) {
//                    if (getSource().getX()-1 == noMove.get(i).getX() && getSource().getY() == noMove.get(i).getY()){
//                        a++;
//                        break;
//                    }
//                }
//                if (a == 0){
//                    canChessMove.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()));
//                }
//            }
//
//            if (getSource().getX()-1>=0 && getSource().getX()-1<=7 && getSource().getY()+1>=0 && getSource().getY()+1<=7
//                    && getNow()[getSource().getX()-1][getSource().getY()+1].getChessColor() != getChessColor()){
//                int a = 0;
//                for (int i = 0; i < noMove.size(); i++) {
//                    if (getSource().getX()-1 == noMove.get(i).getX() && getSource().getY()+1 == noMove.get(i).getY()){
//                        a++;
//                        break;
//                    }
//                }
//                if (a == 0){
//                    canChessMove.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
//                }
//            }
//
//            if (getSource().getX()>=0 && getSource().getX()<=7 && getSource().getY()-1>=0 && getSource().getY()-1<=7
//                    && getNow()[getSource().getX()][getSource().getY()-1].getChessColor() != getChessColor()){
//                int a = 0;
//                for (int i = 0; i < noMove.size(); i++) {
//                    if (getSource().getX() == noMove.get(i).getX() && getSource().getY()-1 == noMove.get(i).getY()){
//                        a++;
//                        break;
//                    }
//                }
//                if (a == 0){
//                    canChessMove.add(new ChessboardPoint(getSource().getX(),getSource().getY()-1));
//                }
//            }
//
//            if (getSource().getX()>=0 && getSource().getX()<=7 && getSource().getY()+1>=0 && getSource().getY()+1<=7
//                    && getNow()[getSource().getX()][getSource().getY()+1].getChessColor() != getChessColor()){
//                int a = 0;
//                for (int i = 0; i < noMove.size(); i++) {
//                    if (getSource().getX() == noMove.get(i).getX() && getSource().getY()+1 == noMove.get(i).getY()){
//                        a++;
//                        break;
//                    }
//                }
//                if (a == 0){
//                    canChessMove.add(new ChessboardPoint(getSource().getX(),getSource().getY()+1));
//                }
//            }
//
//            if (getSource().getX()+1>=0 && getSource().getX()+1<=7 && getSource().getY()-1>=0 && getSource().getY()-1<=7
//                    && getNow()[getSource().getX()+1][getSource().getY()-1].getChessColor() != getChessColor()){
//                int a = 0;
//                for (int i = 0; i < noMove.size(); i++) {
//                    if (getSource().getX()+1 == noMove.get(i).getX() && getSource().getY()-1 == noMove.get(i).getY()){
//                        a++;
//                        break;
//                    }
//                }
//                if (a == 0){
//                    canChessMove.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));
//                }
//            }
//
//            if (getSource().getX()+1>=0 && getSource().getX()+1<=7 && getSource().getY()>=0 && getSource().getY()<=7
//                    && getNow()[getSource().getX()+1][getSource().getY()].getChessColor() != getChessColor()){
//                int a = 0;
//                for (int i = 0; i < noMove.size(); i++) {
//                    if (getSource().getX()+1 == noMove.get(i).getX() && getSource().getY() == noMove.get(i).getY()){
//                        a++;
//                        break;
//                    }
//                }
//                if (a == 0){
//                    canChessMove.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()));
//                }
//            }
//
//            if (getSource().getX()+1>=0 && getSource().getX()+1<=7 && getSource().getY()+1>=0 && getSource().getY()+1<=7
//                    && getNow()[getSource().getX()+1][getSource().getY()+1].getChessColor() != getChessColor()){
//                int a = 0;
//                for (int i = 0; i < noMove.size(); i++) {
//                    if (getSource().getX()+1 == noMove.get(i).getX() && getSource().getY()+1 == noMove.get(i).getY()){
//                        a++;
//                        break;
//                    }
//                }
//                if (a == 0){
//                    canChessMove.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
//                }
//            }
//
//            int x = 0, y = 0;
//            for (int i = 0; i < 8; i++) {
//                for (int j = 0; j < 8; j++) {
//                    if (getNow()[i][j].getName() == 'K'){
//                        x = i;
//                        y = j;
//                    }
//                }
//            }
//
//            if (Math.abs(getSource().getX()-x) == 2 || Math.abs(getSource().getY()-y) == 2){
//                if (getSource().getX() - x == 2){
//                    if (getSource().getY()-y == -2){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
//                    }
//
//                    if (getSource().getY()-y == -1){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()-1,getSource().getY()));
//                    }
//
//                    if (getSource().getY() == y){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()-1,getSource().getY()));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
//                    }
//
//                    if (getSource().getY()-y == 1){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()-1,getSource().getY()));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
//                    }
//
//                    if (getSource().getY()-y == 2){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
//                    }
//                }
//
//                if (getSource().getX() - x == 1){
//                    if (getSource().getY()-y == -2){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX(),getSource().getY()+1));
//                    }
//                    if (getSource().getY()-y == 2){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX(),getSource().getY()-1));
//                    }
//                }
//
//                if (getSource().getX() == x){
//                    if (getSource().getY()-y == -2){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX(),getSource().getY()+1));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
//                    }
//                    if (getSource().getY()-y == 2){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX(),getSource().getY()-1));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));
//                    }
//                }
//
//                if (getSource().getX()-x == -1){
//                    if (getSource().getY()-y == -2){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX(),getSource().getY()+1));
//                    }
//                    if (getSource().getY()-y == 2){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX(),getSource().getY()-1));
//                    }
//                }
//
//                if (getSource().getX()-x == -2){
//                    if (getSource().getY()-y == -2){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
//                    }
//
//                    if (getSource().getY()-y == -1){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()+1,getSource().getY()));
//                    }
//
//                    if (getSource().getY() == y){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()+1,getSource().getY()));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));
//                    }
//
//                    if (getSource().getY()-y == 1){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()+1,getSource().getY()));
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));
//                    }
//
//                    if (getSource().getY()-y == 2){
//                        canChessMove.remove(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));
//                    }
//                }
//            }
//        }

        ArrayList<ChessboardPoint> newCanChessMove = new ArrayList<>();
        for (int i = 0; i < canChessMove.size(); i++) {
            newCanChessMove.add(sort(canChessMove).get(i));
        }

        return newCanChessMove;
    }
}
