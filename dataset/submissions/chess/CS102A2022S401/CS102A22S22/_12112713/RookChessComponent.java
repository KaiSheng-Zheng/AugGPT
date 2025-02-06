import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessColor chessColor, ChessboardPoint source, char name){
        super(source, chessColor, name);
    }
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> points = new ArrayList<>();
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
        if(points.size() == 0){
            return new ArrayList<>();
        }else{
            return points;
        }
    }
}
