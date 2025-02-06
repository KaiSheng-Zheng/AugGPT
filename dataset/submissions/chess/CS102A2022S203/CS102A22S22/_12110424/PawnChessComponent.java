import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(int x, int y, ChessColor a, char name) {
        super.setSource(new ChessboardPoint(x,y));
        super.setChessColor(a);
        super.setName(name);
    }

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        if (super.getChessColor()==ChessColor.BLACK){
            if (super.getSource().getX()+1<8&&
                    super.getComponents()[super.getSource().getX()+1][super.getSource().getY()].getChessColor()==ChessColor.NONE){
                canMoveTo.add(new ChessboardPoint(super.getSource().getX()+1,super.getSource().getY()));
                if (super.getSource().getX()==1&&
                        super.getComponents()[3][super.getSource().getY()].getChessColor()==ChessColor.NONE){
                    canMoveTo.add(new ChessboardPoint(3,super.getSource().getY()));
                }
            }
            if (super.getSource().getX()+1<8&&super.getSource().getY()+1<8&&
                    super.getComponents()[super.getSource().getX()+1][super.getSource().getY()+1].getChessColor()==ChessColor.WHITE){
                canMoveTo.add(new ChessboardPoint(super.getSource().getX()+1,super.getSource().getY()+1));
            }
            if (super.getSource().getX()+1<8&&super.getSource().getY()-1>=0&&
                    super.getComponents()[super.getSource().getX()+1][super.getSource().getY()-1].getChessColor()==ChessColor.WHITE){
                canMoveTo.add(new ChessboardPoint(super.getSource().getX()+1,super.getSource().getY()-1));
            }
        } else {
            if (super.getSource().getX()-1>=0&&
                    super.getComponents()[super.getSource().getX()-1][super.getSource().getY()].getChessColor()==ChessColor.NONE){
                canMoveTo.add(new ChessboardPoint(super.getSource().getX()-1,super.getSource().getY()));
                if (super.getSource().getX()==6&&
                        super.getComponents()[4][super.getSource().getY()].getChessColor()==ChessColor.NONE){
                    canMoveTo.add(new ChessboardPoint(4,super.getSource().getY()));
                }
            }
            if (super.getSource().getX()-1>=0&&super.getSource().getY()-1>=0&&
                    super.getComponents()[super.getSource().getX()-1][super.getSource().getY()-1].getChessColor()==ChessColor.BLACK){
                canMoveTo.add(new ChessboardPoint(super.getSource().getX()-1,super.getSource().getY()-1));
            }
            if (super.getSource().getX()-1>=0&&super.getSource().getY()+1<8&&
                    super.getComponents()[super.getSource().getX()+1][super.getSource().getY()-1].getChessColor()==ChessColor.BLACK){
                canMoveTo.add(new ChessboardPoint(super.getSource().getX()+1,super.getSource().getY()-1));
            }
        }
        return canMoveTo;

    }
}
