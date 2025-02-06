import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessColor chessColor, ChessboardPoint source, char name){
        super(source, chessColor, name);
    }
    public List<ChessboardPoint> canMoveTo(){
        if(getChessColor() == ChessColor.BLACK){
            ArrayList<ChessboardPoint> points = new ArrayList<>();
            if(getSource().offset(1, 1) != null){
                if(getChessboard()[getSource().getX() + 1][getSource().getY() + 1].getChessColor() == ChessColor.WHITE){
                    points.add(getSource().offset(1, 1));
                }
            }
            if(getSource().offset(1, -1) != null){
                if(getChessboard()[getSource().getX() + 1][getSource().getY() - 1].getChessColor() == ChessColor.WHITE){
                    points.add(getSource().offset(1, -1));
                }
            }
            if(getSource().getX() == 1){
                if(getChessboard()[getSource().getX() + 1][getSource().getY()] instanceof EmptySlotComponent){
                    points.add(getSource().offset(1, 0));
                }
                if(getChessboard()[getSource().getX() + 1][getSource().getY()] instanceof EmptySlotComponent && getChessboard()[getSource().getX() + 2][getSource().getY()] instanceof EmptySlotComponent){
                    points.add(getSource().offset(2, 0));
                }
            }else{
                if(getSource().offset(1, 0) != null){
                    if(getChessboard()[getSource().getX() + 1][getSource().getY()] instanceof EmptySlotComponent){
                        points.add(getSource().offset(1, 0));
                    }
                }
            }
            return points;
        }else{
            ArrayList<ChessboardPoint> points = new ArrayList<>();
            if(getSource().offset(-1, 1) != null){
                if(getChessboard()[getSource().getX() - 1][getSource().getY() + 1].getChessColor() == ChessColor.BLACK){
                    points.add(getSource().offset(-1, 1));
                }
            }
            if(getSource().offset(-1, -1) != null){
                if(getChessboard()[getSource().getX() - 1][getSource().getY() - 1].getChessColor() == ChessColor.BLACK){
                    points.add(getSource().offset(-1, -1));
                }
            }
            if(getSource().getX() == 6){
                if(getChessboard()[getSource().getX() - 1][getSource().getY()] instanceof EmptySlotComponent){
                    points.add(getSource().offset(-1, 0));
                }
                if(getChessboard()[getSource().getX() - 1][getSource().getY()] instanceof EmptySlotComponent && getChessboard()[getSource().getX() - 2][getSource().getY()] instanceof EmptySlotComponent){
                    points.add(getSource().offset(-2, 0));
                }
            }else{
                if(getSource().offset(-1, 0) != null){
                    if(getChessboard()[getSource().getX() - 1][getSource().getY()] instanceof EmptySlotComponent){
                        points.add(getSource().offset(-1, 0));
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
}
