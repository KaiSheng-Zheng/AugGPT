import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PawnChessComponent extends ChessComponent{


    public PawnChessComponent(char c, int i, int j, ChessComponent[][] chessComponents) {
        super(c,i,j,chessComponents);
    }



    @Override
    public List<ChessboardPoint> canMoveTo() {
        cmt.clear();
        if (getChessColor()==ChessColor.BLACK){
            ChessboardPoint c1=new ChessboardPoint(getSource().getX()+1, getSource().getY()-1);
            ChessboardPoint c2=new ChessboardPoint(getSource().getX()+1, getSource().getY()+1);
            ChessboardPoint c3=new ChessboardPoint(getSource().getX()+1, getSource().getY());
            ChessboardPoint c4=new ChessboardPoint(getSource().getX()+2, getSource().getY());

            boolean b=false;
            if(getChessComponent(c1).getChessColor()==ChessColor.WHITE){
                cmt.add(c1);
            }
            if(getChessComponent(c3) instanceof EmptySlotComponent){
                cmt.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()));
                b=true;
            }
            if(getChessComponent(c2).getChessColor()==ChessColor.WHITE){
                cmt.add(c2);
            }
            if (getSource().getX()==1&&b&&getChessComponent(c4) instanceof EmptySlotComponent){
                cmt.add(c4);
            }
        }else if (getChessColor()==ChessColor.WHITE){
            ChessboardPoint c1=new ChessboardPoint(getSource().getX()-1, getSource().getY()-1);
            ChessboardPoint c2=new ChessboardPoint(getSource().getX()-1, getSource().getY()+1);
            ChessboardPoint c3=new ChessboardPoint(getSource().getX()-1, getSource().getY()); // missing checking this.
            ChessboardPoint c4=new ChessboardPoint(getSource().getX()-2, getSource().getY());

            boolean b=false;
            //should be getSource().getX()==6 for WHITE, 1 is for BLACK. 
            if (getSource().getX()==1&&getChessComponent(c3) instanceof EmptySlotComponent&&getChessComponent(c4) instanceof EmptySlotComponent){
                cmt.add(c4);
                b=true;
            }
            if(getChessComponent(c1).getChessColor()==ChessColor.BLACK){
                cmt.add(c1);
            }
            if(b){
                cmt.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()));
            }
            if(getChessComponent(c2).getChessColor()==ChessColor.BLACK){
                cmt.add(c2);
            }
        }
        cmt.removeIf(chessboardPoint -> chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==getChessColor());
        cmt.removeIf(Objects::isNull);
        return cmt;
    }
}