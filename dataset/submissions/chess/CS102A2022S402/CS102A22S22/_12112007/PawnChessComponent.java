import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint chessboardPoint,ChessColor color,char name){
        super(chessboardPoint, color,name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> list=new ArrayList<>();
        ChessboardPoint source = getChessboardPoint();
        if (getChessColor()==ChessColor.BLACK){
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++){
                    ChessboardPoint destination=ConcreteChessGame.getChessComponents()[i][j].getChessboardPoint();
                    if (source.getX()==1){
                        if (source.getY()==destination.getY()){
                            if (destination.getX()==source.getX()+2&&ConcreteChessGame.getChessComponents()[source.getX()+1][source.getY()] instanceof EmptySlotComponent&&ConcreteChessGame.getChessComponents()[source.getX()+2][source.getY()] instanceof EmptySlotComponent){
                                list.add(destination);
                            }
                        }
                    }
                    if (destination.getY()==source.getY()&&destination.getX()==source.getX()+1&&ConcreteChessGame.getChessComponents()[destination.getX()][destination.getY()]instanceof EmptySlotComponent){
                        list.add(destination);
                    }
                    if (destination.getY()==source.getY()-1&&destination.getX()==source.getX()+1&& ConcreteChessGame.getChessComponents()[destination.getX()][destination.getY()].getChessColor()==ChessColor.WHITE){
                        list.add(destination);
                    }
                    if (destination.getY()==source.getY()+1&&destination.getX()==source.getX()+1&&ConcreteChessGame.getChessComponents()[destination.getX()][destination.getY()].getChessColor()==ChessColor.WHITE){
                        list.add(destination);
                    }
                }
            }
        }
        else if (getChessColor()==ChessColor.WHITE){
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++){
                    ChessboardPoint destination=ConcreteChessGame.getChessComponents()[i][j].getChessboardPoint();
                    if (source.getX()==6){
                        if (source.getY()==destination.getY()){
                            if (destination.getX()==source.getX()-2&&ConcreteChessGame.getChessComponents()[source.getX()-1][source.getY()] instanceof EmptySlotComponent&&ConcreteChessGame.getChessComponents()[source.getX()-2][source.getY()] instanceof EmptySlotComponent){
                                list.add(destination);
                            }
                        }
                    }
                    if (destination.getY()==source.getY()&&destination.getX()==source.getX()-1&&ConcreteChessGame.getChessComponents()[destination.getX()][destination.getY()]instanceof EmptySlotComponent){
                        list.add(destination);
                    }
                    if (destination.getY()==source.getY()-1&&destination.getX()==source.getX()-1&& ConcreteChessGame.getChessComponents()[destination.getX()][destination.getY()].getChessColor()==ChessColor.BLACK){
                        list.add(destination);
                    }
                    if (destination.getY()==source.getY()+1&&destination.getX()==source.getX()-1&&ConcreteChessGame.getChessComponents()[destination.getX()][destination.getY()].getChessColor()==ChessColor.BLACK){
                        list.add(destination);
                    }
                }
            }
        }
        return list;
    }
}
