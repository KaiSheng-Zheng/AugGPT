import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private boolean isFirstMove;

    public PawnChessComponent(ChessColor chessColor,ChessboardPoint chessboardPoint,ChessComponent[][] chessComponents) {
        super(chessColor,chessComponents);
        this.name=chessColor==ChessColor.BLACK?'P':'p';
        setSource(chessboardPoint);
        isFirstMove=true;
    }


    public void setFirstMove(boolean firstMove) {
        isFirstMove = firstMove;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> possibleMove=new ArrayList<>();

        int direc=getChessColor()==ChessColor.BLACK?1:-1;

        if(!(getSource().getX()==1||getSource().getX()==6)){
            isFirstMove=false;
        }

        if(isFirstMove){
            int m= getSource().getX()+direc, n= getSource().getY();
            if(getChessComponents()[m][n] instanceof EmptySlotComponent){
                possibleMove.add(new ChessboardPoint(m,n));
                m+=direc;
                if(getChessComponents()[m][n] instanceof EmptySlotComponent){
                    possibleMove.add(new ChessboardPoint(m,n));
                }
            }
        }
        else{
            int m= getSource().getX()+direc,n= getSource().getY();
            if(getChessComponents()[m][n] instanceof EmptySlotComponent){
                possibleMove.add(new ChessboardPoint(m,n));
            }
        }

        int m= getSource().getX()+direc,n= getSource().getY();
        if(m>=0&&m<=7&&n-1>=0){
            if(!(getChessComponents()[m][n-1] instanceof EmptySlotComponent)){
                if(getChessComponents()[m][n-1].getChessColor()!=getChessColor()){
                    possibleMove.add(new ChessboardPoint(m,n-1));
                }
            }
        }

        if(m>=0&&m<=7&&n+1<=7){
            if(!(getChessComponents()[m][n+1] instanceof EmptySlotComponent)){
                if(getChessComponents()[m][n+1].getChessColor()!=getChessColor()){
                    possibleMove.add(new ChessboardPoint(m,n+1));
                }
            }
        }

        return possibleMove;
    }
}
