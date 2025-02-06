import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessColor color,Character name,ChessboardPoint source){
        super(color,name,source);
    }
    public  PawnChessComponent(){
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List <ChessboardPoint> canMove=new ArrayList<>();
        if (getSource()==null){return canMove;}
        if (getChessColor()==ChessColor.WHITE){
            if(getSource().getX()==6){//walk
                if (chessboard[getSource().getX()-2][getSource().getY()]instanceof EmptySlotComponent){
                    canMove.add(new ChessboardPoint(getSource().getX()-2,getSource().getY()));
                }
            }
            if(getSource().getX()>=1){//walk
                if (chessboard[getSource().getX()-1][getSource().getY()]instanceof EmptySlotComponent){
                    canMove.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()));
                }
            }
            //eat other
            if (getSource().getY()<=6&&getSource().getX()>=1
                    && chessboard[getSource().getX()-1][getSource().getY()+1].getChessColor()==ChessColor.BLACK){
                canMove.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
            }
            if (getSource().getY()<=6&&getSource().getX()>=1
                    && chessboard[getSource().getX()-1][getSource().getY()-1].getChessColor()==ChessColor.BLACK){
                canMove.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
            }
        }else if (getChessColor()==ChessColor.BLACK){
            if(getSource().getX()==1){//walk
                if (chessboard[getSource().getX()+2][getSource().getY()]instanceof EmptySlotComponent){
                    canMove.add(new ChessboardPoint(getSource().getX()+2,getSource().getY()));
                }
            }
            if(getSource().getX()<=6){//walk
                if (chessboard[getSource().getX()+1][getSource().getY()]instanceof EmptySlotComponent){
                    canMove.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()));
                }
            }
            //eat other
            if (getSource().getY()<=6&&getSource().getX()<=6
                    && chessboard[getSource().getX()+1][getSource().getY()+1].getChessColor()==ChessColor.WHITE){
                canMove.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
            }
            if (getSource().getY()<=6&&getSource().getX()<=6 // this boundary check does not eliminate the case y = 0, causing ArrayIndexOutOfBoundException
                    && chessboard[getSource().getX()-1][getSource().getY()-1].getChessColor()==ChessColor.WHITE){
                canMove.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
            }
        }
        return canMove;
    }


}
