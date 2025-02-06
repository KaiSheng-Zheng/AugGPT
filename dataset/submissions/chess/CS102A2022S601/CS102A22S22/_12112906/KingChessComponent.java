import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessColor chessColor,ChessboardPoint chessboardPoint,ChessComponent[][] chessComponents) {
        super(chessColor,chessComponents);
        this.name=chessColor==ChessColor.BLACK?'K':'k';
        setSource(chessboardPoint);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> possibleMove=new ArrayList<>();

        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int m=getSource().getX()+i,n=getSource().getY()+j;
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
        }

        return possibleMove;
    }
}
