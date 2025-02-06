import java.util.*;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(int x, int y, ChessColor chessColor, char name) {
        super(x, y, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint>res=new ArrayList<>() ;
        int sourceX=getSource().getX();int sourceY=getSource().getY();
        for (int i=getSource().getX()-1;i<getSource().getX()+2;i++){
            for (int j=getSource().getY()-1;j<getSource().getY()+2;j++){
                if (0<=i&&i<=7&&0<=j&&j<=7){
                    if (i!=getSource().getX()||j!=getSource().getY()){
                        if (ConcreteChessGame.chessComponents2[i][j].getChessColor()!=getChessColor()){
                            res.add(new ChessboardPoint(i,j));
                    }
                }
            }
        }
        }
        return res;
    }
}
