import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessColor chessColor, ChessboardPoint source, char name){
        super(source, chessColor, name);
    }
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> points = new ArrayList<>();
        if(getSource().offset(1, 0) != null){
            if(getChessboard()[getSource().getX() + 1][getSource().getY()].getChessColor() != getChessColor()){
                points.add(getSource().offset(1, 0));
            }
        }
        if(getSource().offset(1, 1) != null){
            if(getChessboard()[getSource().getX() + 1][getSource().getY() + 1].getChessColor() != getChessColor()){
                points.add(getSource().offset(1, 1));
            }
        }
        if(getSource().offset(0, 1) != null){
            if(getChessboard()[getSource().getX()][getSource().getY() + 1].getChessColor() != getChessColor()){
                points.add(getSource().offset(0, 1));
            }
        }
        if(getSource().offset(-1, 0) != null){
            if(getChessboard()[getSource().getX() - 1][getSource().getY()].getChessColor() != getChessColor()){
                points.add(getSource().offset(-1, 0));
            }
        }
        if(getSource().offset(0, -1) != null){
            if(getChessboard()[getSource().getX()][getSource().getY() - 1].getChessColor() != getChessColor()){
                points.add(getSource().offset(0, -1));
            }
        }
        if(getSource().offset(-1, -1) != null){
            if (getChessboard()[getSource().getX() - 1][getSource().getY() - 1].getChessColor() != getChessColor()){
                points.add(getSource().offset(-1, -1));
            }
        }
        if(getSource().offset(-1, 1) != null){
            if(getChessboard()[getSource().getX() - 1][getSource().getY() + 1].getChessColor() != getChessColor()){
                points.add(getSource().offset(-1, 1));
            }
        }
        if(getSource().offset(1, -1) != null){
            if(getChessboard()[getSource().getX() + 1][getSource().getY() - 1].getChessColor() != getChessColor()){
                points.add(getSource().offset(1, -1));
            }
        }
        if(points.size() == 0){
            return new ArrayList<>();
        }else{
            for (int i = 0; i < points.size(); i++) {
                if(getChessboard()[points.get(i).getX()][points.get(i).getY()].getChessColor() == this.getChessColor()){
                    points.remove(i);
                }
            }
            if(points.size() == 0){
                return new ArrayList<>();
            }else{
                return points;
            }
        }
    }
}
