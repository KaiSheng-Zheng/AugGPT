import java.util.ArrayList;
import java.util.List;

public class  KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor,char name){
        super(chessboardPoint,chessColor,name);

    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canto=new ArrayList<>();
        int x= getSource().getX();
        int y= getSource().getY();
        if(x+1<=7){
            canto.add(new ChessboardPoint(x+1,y));
            if(y+1<=7){
                canto.add(new ChessboardPoint(x+1,y+1));
            }
            if(y-1>=0){
                canto.add(new ChessboardPoint(x+1,y-1));
            }
        }
        if(x-1>=0){
            canto.add(new ChessboardPoint(x-1,y));
            if(y+1<=7){
                canto.add(new ChessboardPoint(x-1,y+1));
            }
            if(y-1>=0){
                canto.add(new ChessboardPoint(x-1,y-1));
            }
        }
        if(y+1<=7){
            canto.add(new ChessboardPoint(x,y+1));
        }
        if(y-1>=0){
            canto.add(new ChessboardPoint(x,y-1));
        }
        List<ChessboardPoint> answer=new ArrayList<>();
        for (ChessboardPoint canMovePoint : canto) {
            if (chessboard[canMovePoint.getX()][canMovePoint.getY()] instanceof EmptySlotComponent || chessboard[canMovePoint.getX()][canMovePoint.getY()].getChessColor() != getChessColor()) {
                answer.add(chessboard[canMovePoint.getX()][canMovePoint.getY()].getSource());
            }
        }
        return answer;
    }
}
