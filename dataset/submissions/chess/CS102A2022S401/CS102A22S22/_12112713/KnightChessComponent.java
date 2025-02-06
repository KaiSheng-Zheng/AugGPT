import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessColor chessColor, ChessboardPoint source, char name){
        super(source, chessColor, name);
    }
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> points = new ArrayList<>();
        if(getSource().offset(-2, -1) != null){
            if(getChessboard()[getSource().getX() - 2][getSource().getY() - 1].getChessColor() != getChessColor())
            points.add(getSource().offset(-2, -1));
        }
        if(getSource().offset(-1, -2) != null){
            if(getChessboard()[getSource().getX() - 1][getSource().getY() - 2].getChessColor() != getChessColor())
            points.add(getSource().offset(-1, -2));
        }
        if(getSource().offset(1, -2) != null){
            if(getChessboard()[getSource().getX() + 1][getSource().getY() - 2].getChessColor() != getChessColor())
            points.add(getSource().offset(1, -2));
        }
        if(getSource().offset(2, -1) != null){
            if(getChessboard()[getSource().getX() + 2][getSource().getY() - 1].getChessColor() != getChessColor())
            points.add(getSource().offset(2, -1));
        }
        if(getSource().offset(2, 1) != null){
            if(getChessboard()[getSource().getX() + 2][getSource().getY() + 1].getChessColor() != getChessColor())
            points.add(getSource().offset(2, 1));
        }
        if(getSource().offset(1, 2) != null){
            if(getChessboard()[getSource().getX() + 1][getSource().getY() + 2].getChessColor() != getChessColor())
            points.add(getSource().offset(1, 2));
        }
        if(getSource().offset(-1, 2) != null){
            if(getChessboard()[getSource().getX() - 1][getSource().getY() + 2].getChessColor() != getChessColor())
            points.add(getSource().offset(-1, 2));
        }
        if(getSource().offset(-2, 1) != null){
            if(getChessboard()[getSource().getX() - 2][getSource().getY() + 1].getChessColor() != getChessColor())
            points.add(getSource().offset(-2, 1));
        }
        if(points.size() == 0){
            return new ArrayList<>();
        }else{
            for (int i = 0; i < points.size(); i++) {
                if(getChessboard()[points.get(i).getX()][points.get(i).getY()].getChessColor() == this.getChessColor()){
                    points.remove(i);
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
