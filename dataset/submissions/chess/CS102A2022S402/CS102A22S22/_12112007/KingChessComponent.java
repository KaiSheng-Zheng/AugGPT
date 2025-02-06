import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(ChessboardPoint chessboardPoint,ChessColor color,char name){
        super(chessboardPoint, color,name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> list=new ArrayList<>();
        ChessboardPoint source = getChessboardPoint();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                ChessboardPoint destination=ConcreteChessGame.getChessComponents()[i][j].getChessboardPoint();
                if (destination.getX()==source.getX()+1&&destination.getY()==source.getY()+1&&ConcreteChessGame.getChessComponents()[i][j].getChessColor()!=getChessColor()){
                    list.add(destination);
                }
                else if (destination.getX()==source.getX()+1&&destination.getY()==source.getY()&&ConcreteChessGame.getChessComponents()[i][j].getChessColor()!=getChessColor()){
                    list.add(destination);
                }
                else if (destination.getX()==source.getX()+1&&destination.getY()==source.getY()-1&&ConcreteChessGame.getChessComponents()[i][j].getChessColor()!=getChessColor()){
                    list.add(destination);
                }
                else if (destination.getX()==source.getX()&&destination.getY()==source.getY()+1&&ConcreteChessGame.getChessComponents()[i][j].getChessColor()!=getChessColor()){
                    list.add(destination);
                }
                else if (destination.getX()==source.getX()&&destination.getY()==source.getY()-1&&ConcreteChessGame.getChessComponents()[i][j].getChessColor()!=getChessColor()){
                    list.add(destination);
                }
                else if (destination.getX()==source.getX()-1&&destination.getY()==source.getY()+1&&ConcreteChessGame.getChessComponents()[i][j].getChessColor()!=getChessColor()){
                    list.add(destination);
                }
                else if (destination.getX()==source.getX()-1&&destination.getY()==source.getY()&&ConcreteChessGame.getChessComponents()[i][j].getChessColor()!=getChessColor()){
                    list.add(destination);
                }
                else if (destination.getX()==source.getX()-1&&destination.getY()==source.getY()-1&&ConcreteChessGame.getChessComponents()[i][j].getChessColor()!=getChessColor()){
                    list.add(destination);
                }
            }
        }
        return list;
    }
}
