import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(int a,int b, ChessColor c, char d) {
        super(a,b,c,d);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> res=new ArrayList<>();
        int i=1;
        int sourceX=getSource().getX();int sourceY=getSource().getY();
        while (sourceY+i<=7){
            if (ConcreteChessGame.chessComponents2[sourceX][sourceY+i].getChessColor()!=getChessColor()){
                res.add(new ChessboardPoint(sourceX,sourceY+i));
            }
            if (ConcreteChessGame.chessComponents2[sourceX][sourceY+i].getChessColor()!=ChessColor.NONE){
                break;
            }
            i++;
        }
        int a=1;
        while (0<=sourceY-a){
            if (ConcreteChessGame.chessComponents2[sourceX][sourceY-a].getChessColor()!=getChessColor()){
                res.add(new ChessboardPoint(sourceX,sourceY-a));
            }
            if (ConcreteChessGame.chessComponents2[sourceX][sourceY-a].getChessColor()!=ChessColor.NONE){
                break;
            }
            a++;
        }
        int b=1;
        while (sourceX+b<=7){
            if (ConcreteChessGame.chessComponents2[sourceX+b][sourceY].getChessColor()!=getChessColor()){
                res.add(new ChessboardPoint(sourceX+b,sourceY));
            }
            if (ConcreteChessGame.chessComponents2[sourceX+b][sourceY].getChessColor()!=ChessColor.NONE){
                break;
            }
            b++;
        }
        int j=1;
        while (0<=sourceX-j){
            if (ConcreteChessGame.chessComponents2[sourceX-j][sourceY].getChessColor()!=getChessColor()){
                res.add(new ChessboardPoint(sourceX-j,sourceY));
            }
            if (ConcreteChessGame.chessComponents2[sourceX-j][sourceY].getChessColor()!=ChessColor.NONE){
                break;
            }
            j++;
        }
        return res;
    }
}
