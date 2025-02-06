import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>  list= new ArrayList<>();
        for (int i = 0; i < getChessComponents().length; i++) {
            for (int j = 0; j < getChessComponents()[i].length; j++) {
                if (MoveTo(getChessComponents(),getChessComponents()[i][j].getSource())&&getChessColor()!=getChessComponents()[i][j].getChessColor()){
                    list.add(getChessComponents()[i][j].getSource());
                }
            }
        }
        return list;
    }


        public boolean MoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getSource();
        if (getChessColor()== ChessColor.BLACK){
            if (source.getX()==1){
                if (destination.getY()==source.getY()&&destination.getX()==getSource().getX()+2){
                    return chessComponents[destination.getX() - 1][destination.getY()] instanceof EmptySlotComponent && chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent;
                }
                else if (destination.getY()==source.getY()&&destination.getX()==source.getX()+1){
                    return chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent;
                }
                else if (Math.abs(source.getY()-destination.getY())==1&&destination.getX()==source.getX()+1){
                    return chessComponents[destination.getX()][destination.getY()].getChessColor() == ChessColor.WHITE;
                }
                else return false;
            }
            else if (destination.getX()==source.getX()+1&&destination.getY()==source.getY()){
                return chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent;
            }
            else if (Math.abs(source.getY()-destination.getY())==1&&destination.getX()==source.getX()+1){
                return chessComponents[destination.getX()][destination.getY()].getChessColor() == ChessColor.WHITE;
            }
            else return false;
        }
        else if (getChessColor()== ChessColor.WHITE){
            if (source.getX()==6){
                if (destination.getY()==source.getY()&&source.getX()==destination.getX()+2){
                    return chessComponents[source.getX() - 1][source.getY()] instanceof EmptySlotComponent && chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent;
                }
                else if (source.getX()==destination.getX()+1&&destination.getY()==source.getY()){
                    return chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent;
                }
                else if (Math.abs(destination.getY()-source.getY())==1&&source.getX()==destination.getX()+1){
                    return chessComponents[destination.getX()][destination.getY()].getChessColor() == ChessColor.BLACK;
                }
                else return false;
            }
            else if (source.getX()==destination.getX()+1&&destination.getY()==source.getY()){
                return chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent;
            }
            else if (Math.abs(destination.getY()-source.getY())==1&&source.getX()==destination.getX()+1){
                return chessComponents[destination.getX()][destination.getY()].getChessColor() == ChessColor.BLACK;
            }
            else return false;
        }
        return false;
    }
    }