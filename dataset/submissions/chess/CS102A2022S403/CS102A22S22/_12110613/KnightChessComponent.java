import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor,char name){
        super(chessboardPoint,chessColor,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x= getSource().getX();
        int y= getSource().getY();
        List<ChessboardPoint> canto=new ArrayList<ChessboardPoint>();
        if(x+2<=7&&y+1<=7){
            canto.add(new ChessboardPoint(x+2,y+1));
        }
        if(x+2<=7&&y-1>=0){
            canto.add(new ChessboardPoint(x+2,y-1));
        }
        if(x-2>=0&&y+1<=7){
            canto.add(new ChessboardPoint(x-2,y+1));
        }
        if(x-2>=0&&y-1>=0){
            canto.add(new ChessboardPoint(x-2,y-1));
        }
        if(x+1<=7&&y+2<=7){
            canto.add(new ChessboardPoint(x+1,y+2));
        }
        if(x+1<=7&&y-2>=0){
            canto.add(new ChessboardPoint(x+1,y-2));
        }
        if(x-1>=0&&y+2<=7){
            canto.add(new ChessboardPoint(x-1,y+2));
        }
        if(x-1>=0&&y-2>=0){
            canto.add(new ChessboardPoint(x-1,y-2));
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
