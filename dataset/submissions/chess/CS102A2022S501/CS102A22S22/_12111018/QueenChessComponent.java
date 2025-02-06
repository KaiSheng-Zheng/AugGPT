import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(int x, int y, ChessColor chessColor, char name) {
        super(x, y, chessColor, name);
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
        int h=1;
        while (0<=sourceY-h){
            if (ConcreteChessGame.chessComponents2[sourceX][sourceY-h].getChessColor()!=getChessColor()){
                res.add(new ChessboardPoint(sourceX,sourceY-h));
            }
            if (ConcreteChessGame.chessComponents2[sourceX][sourceY-h].getChessColor()!=ChessColor.NONE){
                break;
            }
            h++;
        }
        int q=1;
        while (sourceX+q<=7){
            if (ConcreteChessGame.chessComponents2[sourceX+q][sourceY].getChessColor()!=getChessColor()){
                res.add(new ChessboardPoint(sourceX+q,sourceY));
            }
            if (ConcreteChessGame.chessComponents2[sourceX+q][sourceY].getChessColor()!=ChessColor.NONE){
                break;
            }
            q++;
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
        int w=1;
        while (getSource().getX()+w<8&&getSource().getY()+w<8){
            int a=getSource().getX()+w;
            int b=getSource().getY()+w;
            if (ConcreteChessGame.chessComponents2[a][b].getChessColor()!=getChessColor()){
                res.add(new ChessboardPoint(a,b));
            }
            if (ConcreteChessGame.chessComponents2[a][b].getChessColor()!=ChessColor.NONE){
                break;
            }
            w++;
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
        int o=1;
        while (getSource().getX()-o>=0&&getSource().getY()+o<8){
            int a=getSource().getX()-o;
            int b=getSource().getY()+o;
            if (ConcreteChessGame.chessComponents2[a][b].getChessColor()!=getChessColor()){
                res.add(new ChessboardPoint(a,b));
            }
            if (ConcreteChessGame.chessComponents2[a][b].getChessColor()!=ChessColor.NONE){
                break;
            }
            o++;
        }
        return res;
    }
}
