import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        super(source,chessColor,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a=new ArrayList<>();
        ChessComponent[][] c=super.getChessComponents();
        if(getChessColor()==ChessColor.WHITE){
            if((getSource().getX()-1)>=0&&c[getSource().getX()-1][getSource().getY()].getChessColor()==ChessColor.NONE){
                a.add(getSource().offset(-1,0));
            }
            if(getSource().getX()==6){
                if(c[getSource().getX()-2][getSource().getY()].getChessColor()==ChessColor.NONE&&c[getSource().getX()-1][getSource().getY()].getChessColor()==ChessColor.NONE){
                    a.add(getSource().offset(-2,0));
                }
            }
            if(getSource().getX()-1>=0&&getSource().getY()-1>=0&&c[getSource().getX()-1][getSource().getY()-1].getChessColor()==ChessColor.BLACK){
                a.add(getSource().offset(-1,-1));
            }
            if(getSource().getX()-1>=0&&getSource().getY()+1<=7&&c[getSource().getX()-1][getSource().getY()+1].getChessColor()==ChessColor.BLACK){
                a.add(getSource().offset(-1,1));
            }

            //black
        }else {
            if(getSource().getX()+1<=7&&c[getSource().getX()+1][getSource().getY()].getChessColor()==ChessColor.NONE){
                a.add(getSource().offset(1,0));
            }
            if(getSource().getX()==1){
                if(c[getSource().getX()+2][getSource().getY()].getChessColor()==ChessColor.NONE&&c[getSource().getX()+1][getSource().getY()].getChessColor()==ChessColor.NONE){
                    a.add(getSource().offset(2,0));
                }
            }
            if(getSource().getX()+1<=7&&getSource().getY()+1<=7&&c[getSource().getX()+1][getSource().getY()+1].getChessColor()==ChessColor.WHITE){
                a.add(getSource().offset(1,1));
            }
            if(getSource().getX()+1<=7&&getSource().getY()-1>=0&&c[getSource().getX()+1][getSource().getY()-1].getChessColor()==ChessColor.WHITE){
                a.add(getSource().offset(1,-1));
            }
        }
        return a;
    }
}