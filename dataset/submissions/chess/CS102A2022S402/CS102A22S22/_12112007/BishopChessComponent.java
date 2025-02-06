import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint chessboardPoint,ChessColor color,char name){
        super(chessboardPoint, color,name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint>list=new ArrayList<>();
        ChessboardPoint source = getChessboardPoint();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                ChessboardPoint destination=ConcreteChessGame.getChessComponents()[i][j].getChessboardPoint();
                boolean m=true;
                if (source.getX()+source.getY()==destination.getX()+destination.getY()&&ConcreteChessGame.getChessComponents()[i][j].getChessColor()!=getChessColor()){
                    int he=source.getX()+source.getY();
                    for (int x=Math.min(source.getX(),destination.getX())+1;x<Math.max(source.getX(),destination.getX());x++){
                        if (!(ConcreteChessGame.getChessComponents()[x][he-x] instanceof EmptySlotComponent)){
                            m=false;
                        }
                    }
                    if (m){
                        list.add(destination);
                    }
                }
                else if (source.getX()-source.getY()==destination.getX()-destination.getY()&&ConcreteChessGame.getChessComponents()[i][j].getChessColor()!=getChessColor()){
                    int he=source.getX()-source.getY();;
                    for (int x=Math.min(source.getX(),destination.getX())+1;x<Math.max(source.getX(),destination.getX());x++){
                        if (!(ConcreteChessGame.getChessComponents()[x][x-he] instanceof EmptySlotComponent)){
                            m=false;
                        }
                    }
                    if (m){
                        list.add(destination);
                    }
                }
            }
        }
        return list;
    }
}
