import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessColor chessColor,ChessboardPoint chessboardPoint,ChessComponent[][] chessComponents) {
        super(chessColor,chessComponents);
        this.name=chessColor==ChessColor.BLACK?'N':'n';
        setSource(chessboardPoint);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> possibleMove=new ArrayList<>();

        int a=-1,b=2;

        for(int i=1;i<=4;i++){
            a*=-1;
            if(i==3) b*=-1;

            int m= getSource().getX()+a,n= getSource().getY()+b;
            if(m>=0&&m<=7&&n>=0&&n<=7){
                if(getChessComponents()[m][n] instanceof EmptySlotComponent){
                    possibleMove.add(new ChessboardPoint(m,n));
                }
                else{
                    if(getChessComponents()[m][n].getChessColor()!=getChessColor()){
                        possibleMove.add(new ChessboardPoint(m,n));
                    }
                }
            }
        }

        a=-2;b=1;

        for(int i=1;i<=4;i++){
            a*=-1;
            if(i==3) b*=-1;

            int m= getSource().getX()+a,n= getSource().getY()+b;
            if(m>=0&&m<=7&&n>=0&&n<=7){
                if(getChessComponents()[m][n] instanceof EmptySlotComponent){
                    possibleMove.add(new ChessboardPoint(m,n));
                }
                else{
                    if(getChessComponents()[m][n].getChessColor()!=getChessColor()){
                        possibleMove.add(new ChessboardPoint(m,n));
                    }
                }
            }
        }

        return possibleMove;
    }
}
