import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(int x, int y, ChessColor chessColor, char name) {
        super(x, y, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint>res=new ArrayList<>();
        if (getChessColor()==ChessColor.BLACK){
            if (getSource().getX()==1){
                int a=getSource().getX()+1;
                int b=getSource().getX()+2;
                if (ConcreteChessGame.chessComponents2[a][getSource().getY()].getChessColor()==ChessColor.NONE){
                    res.add(new ChessboardPoint(a,getSource().getY()));
                }
                if (ConcreteChessGame.chessComponents2[a][getSource().getY()].getChessColor()==ChessColor.NONE){
                    if (ConcreteChessGame.chessComponents2[b][getSource().getY()].getChessColor()==ChessColor.NONE){
                        res.add(new ChessboardPoint(b,getSource().getY()));
                }
            }
            }

            else {
                int a=getSource().getX()+1;
                if (0<=a&&a<=7){
                    if (ConcreteChessGame.chessComponents2[a][getSource().getY()].getChessColor()==ChessColor.NONE){
                        res.add(new ChessboardPoint(a,getSource().getY()));
                    }
                }
            }
            int a=getSource().getX();int b=getSource().getY();
            if (0<=a+1&&a+1<=7&&0<=b-1&&b-1<=7){
                if (ConcreteChessGame.chessComponents2[a+1][b-1].getChessColor()==ChessColor.WHITE){
                    res.add(new ChessboardPoint(a+1,b-1));
                }
            }
            if (0<=a+1&&a+1<=7&&0<=b+1&&b+1<=7){
                if (ConcreteChessGame.chessComponents2[a+1][b+1].getChessColor()==ChessColor.WHITE){
                    res.add(new ChessboardPoint(a+1,b+1));
                }
            }
        }
        else {
            if (getSource().getX()==6){
                int a=getSource().getX()-1;
                int b=getSource().getX()-2;
                if (ConcreteChessGame.chessComponents2[a][getSource().getY()].getChessColor()==ChessColor.NONE){
                    res.add(new ChessboardPoint(a,getSource().getY()));
                }
                if (ConcreteChessGame.chessComponents2[a][getSource().getY()].getChessColor()==ChessColor.NONE){
                    if (ConcreteChessGame.chessComponents2[b][getSource().getY()].getChessColor()==ChessColor.NONE){
                    res.add(new ChessboardPoint(b,getSource().getY()));
                    }
                }
            }
            else {
                int a=getSource().getX()-1;
                if (0<=a&&a<=7){
                    if (ConcreteChessGame.chessComponents2[a][getSource().getY()].getChessColor()==ChessColor.NONE){
                        res.add(new ChessboardPoint(a,getSource().getY()));
                    }
                }
            }
            int a=getSource().getX();int b=getSource().getY();
            if (0<=a-1&&a-1<=7&&0<=b-1&&b-1<=7){
                if (ConcreteChessGame.chessComponents2[a-1][b-1].getChessColor()==ChessColor.BLACK){
                    res.add(new ChessboardPoint(a-1,b-1));
                }
            }
            if (0<=a-1&&a-1<=7&&0<=b+1&&b+1<=7){
                if (ConcreteChessGame.chessComponents2[a-1][b+1].getChessColor()==ChessColor.BLACK){
                    res.add(new ChessboardPoint(a-1,b+1));
                }
            }
        }
        return res;
    }
}
