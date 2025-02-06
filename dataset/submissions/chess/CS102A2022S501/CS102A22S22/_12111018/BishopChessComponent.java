import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(int a,int b,ChessColor c,char d) {
        super(a,b,c,d);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> res=new ArrayList<>();
        int i=1;
        while (getSource().getX()+i<8&&getSource().getY()+i<8){
            int a=getSource().getX()+i;
            int b=getSource().getY()+i;
            if (ConcreteChessGame.chessComponents2[a][b].getChessColor()!=getChessColor()){
                res.add(new ChessboardPoint(a,b));
            }
            if (ConcreteChessGame.chessComponents2[a][b].getChessColor()!=ChessColor.NONE){
                break;
            }
            i++;
        }
        int k=1;
        while (getSource().getX()-k>=0&&getSource().getY()-k>=0){
            int a=getSource().getX()-k;
            int b=getSource().getY()-k;
            if (ConcreteChessGame.chessComponents2[a][b].getChessColor()!=getChessColor()){
                res.add(new ChessboardPoint(a,b));
            }
            if (ConcreteChessGame.chessComponents2[a][b].getChessColor()!=ChessColor.NONE){
                break;
            }
            k++;
        }

        int m=1;
        while (getSource().getX()+m<8&&getSource().getY()-m>=0){
            int a=getSource().getX()+m;
            int b=getSource().getY()-m;
            if (ConcreteChessGame.chessComponents2[a][b].getChessColor()!=getChessColor()){
                res.add(new ChessboardPoint(a,b));
            }
            if (ConcreteChessGame.chessComponents2[a][b].getChessColor()!=ChessColor.NONE){
                break;
            }
            m++;
        }
        int j=1;
        while (getSource().getX()-j>=0&&getSource().getY()+j<8){
            int a=getSource().getX()-j;
            int b=getSource().getY()+j;
            if (ConcreteChessGame.chessComponents2[a][b].getChessColor()!=getChessColor()){
                res.add(new ChessboardPoint(a,b));
            }
            if (ConcreteChessGame.chessComponents2[a][b].getChessColor()!=ChessColor.NONE){
                break;
            }
            j++;
        }

        return res;
    }
}
