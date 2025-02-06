import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessColor chessColor, ChessboardPoint source, char name){
        super(source, chessColor, name );
    }
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> points = new ArrayList<>();
        int initXPlus1 = getSource().getX() + 1;
        int initXPlus2 = getSource().getX() + 1;
        int initXMinus1 = getSource().getX() - 1;
        int initXMinus2 = getSource().getX() - 1;
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
