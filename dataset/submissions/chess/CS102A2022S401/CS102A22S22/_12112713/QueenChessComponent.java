import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessColor chessColor, ChessboardPoint source, char name){
        super(source, chessColor, name);
    }
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> points = new ArrayList<>();
        int initXPlus1 = getSource().getX() + 1;
        int initXMinus1 = getSource().getX() - 1;
        int initXPlus2 = getSource().getX() + 1;
        int initXMinus2 = getSource().getX() - 1;
        for (int i = getSource().getX() + 1; i <= 7; i++) {
            if(getSource().offset(i - getSource().getX(), 0) != null){
                if(getChessboard()[i][getSource().getY()] instanceof EmptySlotComponent){
                    points.add(getSource().offset(i - getSource().getX(), 0));
                }else if(getChessboard()[i][getSource().getY()].getChessColor() != getChessColor()){
                    points.add(getSource().offset(i - getSource().getX(), 0));
                    break;
                }else if(getChessboard()[i][getSource().getY()].getChessColor() == getChessColor()){
                    break;
                }
            }
        }
        for (int i = getSource().getX() - 1; i >= 0 ; i--) {
            if(getSource().offset(i - getSource().getX(), 0) != null){
                if(getChessboard()[i][getSource().getY()] instanceof EmptySlotComponent){
                    points.add(getSource().offset(i - getSource().getX(), 0));
                }else if(getChessboard()[i][getSource().getY()].getChessColor() != getChessColor()){
                    points.add(getSource().offset(i - getSource().getX(), 0));
                    break;
                }else if(getChessboard()[i][getSource().getY()].getChessColor() == getChessColor()){
                    break;
                }
            }
        }
        for (int i = getSource().getY() + 1; i <= 7 ; i++) {
            if(getSource().offset(0, i - getSource().getY()) != null){
                if(getChessboard()[getSource().getX()][i] instanceof EmptySlotComponent){
                    points.add(getSource().offset(0, i - getSource().getY()));
                }else if(getChessboard()[getSource().getX()][i].getChessColor() != getChessColor()){
                    points.add(getSource().offset(0, i - getSource().getY()));
                    break;
                }else if(getChessboard()[getSource().getX()][i].getChessColor() == getChessColor()){
                    break;
                }
            }
        }
        for (int i = getSource().getY() - 1; i >= 0 ; i--) {
            if(getSource().offset(0, i - getSource().getY()) != null){
                if(getChessboard()[getSource().getX()][i] instanceof EmptySlotComponent){
                    points.add(getSource().offset(0, i - getSource().getY()));
                }else if(getChessboard()[getSource().getX()][i].getChessColor() != getChessColor()){
                    points.add(getSource().offset(0, i - getSource().getY()));
                    break;
                }else if(getChessboard()[getSource().getX()][i].getChessColor() == getChessColor()){
                    break;
                }
            }
        }
        for (int i = getSource().getY() + 1; i <= 7 & initXPlus1 <= 7; i++, initXPlus1++) {
            if(getSource().offset(initXPlus1 - getSource().getX(), i - getSource().getY()) != null){
                if(getChessboard()[initXPlus1][i] instanceof EmptySlotComponent){
                    points.add(getSource().offset(initXPlus1 - getSource().getX(), i - getSource().getY()));
                }else if(getChessboard()[initXPlus1][i].getChessColor() != getChessColor()){
                    points.add(getSource().offset(initXPlus1 - getSource().getX(), i - getSource().getY()));
                    break;
                }else if(getChessboard()[initXPlus1][i].getChessColor() == getChessColor()){
                    break;
                }
            }
        }
        for (int i = getSource().getY() - 1; i >= 0 & initXMinus1 >= 0; i--, initXMinus1--) {
            if(getSource().offset(initXMinus1 - getSource().getX(), i - getSource().getY()) != null){
                if(getChessboard()[initXMinus1][i] instanceof EmptySlotComponent){
                    points.add(getSource().offset(initXMinus1 - getSource().getX(), i - getSource().getY()));
                }else if(getChessboard()[initXMinus1][i].getChessColor() != getChessColor()){
                    points.add(getSource().offset(initXMinus1 - getSource().getX(), i - getSource().getY()));
                    break;
                }else if(getChessboard()[initXMinus1][i].getChessColor() == getChessColor()){
                    break;
                }
            }
        }
        for (int i = getSource().getY() + 1; i <= 7 & initXMinus2 >= 0; i++, initXMinus2--) {
            if(getSource().offset(initXMinus2 - getSource().getX(), i - getSource().getY()) != null){
                if(getChessboard()[initXMinus2][i] instanceof EmptySlotComponent){
                    points.add(getSource().offset(initXMinus2 - getSource().getX(), i - getSource().getY()));
                }else if(getChessboard()[initXMinus2][i].getChessColor() != getChessColor()){
                    points.add(getSource().offset(initXMinus2 - getSource().getX(), i - getSource().getY()));
                    break;
                }else if(getChessboard()[initXMinus2][i].getChessColor() == getChessColor()){
                    break;
                }
            }
        }
        for (int i = getSource().getY() - 1; i >= 0 & initXPlus2 <= 7; i--, initXPlus2++) {
            if(getSource().offset(initXPlus2 - getSource().getX(), i - getSource().getY()) != null){
                if(getChessboard()[initXPlus2][i] instanceof EmptySlotComponent){
                    points.add(getSource().offset(initXPlus2 - getSource().getX(), i - getSource().getY()));
                }else if(getChessboard()[initXPlus2][i].getChessColor() != getChessColor()){
                    points.add(getSource().offset(initXPlus2 - getSource().getX(), i - getSource().getY()));
                    break;
                }else if(getChessboard()[initXPlus2][i].getChessColor() == getChessColor()){
                    break;
                }
            }
        }
        if(points.size() == 0){
            return new ArrayList<>();
        }else{
            return points;
        }
    }
}