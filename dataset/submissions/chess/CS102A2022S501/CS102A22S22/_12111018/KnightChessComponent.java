import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(int a,int b,ChessColor c,char d) {
        super(a,b,c,d);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint>res=new ArrayList<>();
        int a=getSource().getX();
        int b=getSource().getY();
        if (0<=a+1&&a+1<=7&&0<=b+2&&b+2<=7){
            if (ConcreteChessGame.chessComponents2[a+1][b+2].getChessColor()!=getChessColor()){
                res.add(new ChessboardPoint(a+1,b+2));
            }
        }
        if (0<=a+1&&a+1<=7&&0<=b-2&&b-2<=7){
            if (ConcreteChessGame.chessComponents2[a+1][b-2].getChessColor()!=getChessColor()){
                res.add(new ChessboardPoint(a+1,b-2));
            }
        }
        if (0<=a-1&&a-1<=7&&0<=b+2&&b+2<=7){
            if (ConcreteChessGame.chessComponents2[a-1][b+2].getChessColor()!=getChessColor()){
                res.add(new ChessboardPoint(a-1,b+2));
            }
        }
        if (0<=a-1&&a-1<=7&&0<=b-2&&b-2<=7){
            if (ConcreteChessGame.chessComponents2[a-1][b-2].getChessColor()!=getChessColor()){
                res.add(new ChessboardPoint(a-1,b-2));
            }
        }
        if (0<=a+2&&a+2<=7&&0<=b+1&&b+1<=7){
            if (ConcreteChessGame.chessComponents2[a+2][b+1].getChessColor()!=getChessColor()){
                res.add(new ChessboardPoint(a+2,b+1));
            }
        }
        if (0<=a+2&&a+2<=7&&0<=b-1&&b-1<=7){
            if (ConcreteChessGame.chessComponents2[a+2][b-1].getChessColor()!=getChessColor()){
                res.add(new ChessboardPoint(a+2,b-1));
            }
        }
        if (0<=a-2&&a-2<=7&&0<=b+1&&b+1<=7){
            if (ConcreteChessGame.chessComponents2[a-2][b+1].getChessColor()!=getChessColor()){
                res.add(new ChessboardPoint(a-2,b+1));
            }
        }
        if (0<=a-2&&a-2<=7&&0<=b-1&&b-1<=7){
            if (ConcreteChessGame.chessComponents2[a-2][b-1].getChessColor()!=getChessColor()){
                res.add(new ChessboardPoint(a-2,b-1));
            }
        }
        return res;
    }
}
