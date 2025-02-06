import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{


    public PawnChessComponent(ChessboardPoint chessboardPoint, ChessColor color, char name) {
        super(chessboardPoint, color, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> list = new ArrayList<>();
        ChessboardPoint source = getSource();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                ChessboardPoint destination  = ConcreteChessGame.getChessComponents()[i][j].getSource();
                if (getChessColor()==ChessColor.BLACK){
                    if (source.getX()==1&&source.getY()==destination.getY()){
                        if (source.getX()+2==destination.getX()&&ConcreteChessGame.getChessComponents()[source.getX()+2][source.getY()] instanceof EmptySlotComponent){
                            list.add(destination);
                        }
                    }
                    if (source.getY()==destination.getY()&&source.getX()+1==destination.getX()&&
                            ConcreteChessGame.getChessComponents()[destination.getX()][destination.getY()] instanceof EmptySlotComponent){
                        list.add(destination);
                    }
                    if (source.getY()==destination.getY()+1&&source.getX()+1==destination.getX()&&
                            ConcreteChessGame.getChessComponents()[destination.getX()][destination.getY()].getChessColor() ==ChessColor.WHITE){
                        list.add(destination);
                    }
                    if (source.getY()==destination.getY()-1&&source.getX()+1==destination.getX()&&
                            ConcreteChessGame.getChessComponents()[destination.getX()][destination.getY()].getChessColor() ==ChessColor.WHITE){
                        list.add(destination);
                    }
                }
                else if (getChessColor()==ChessColor.WHITE){
                    if (source.getX()==7&&source.getY()==destination.getY()){
                        if (source.getX()-2==destination.getX()&&ConcreteChessGame.getChessComponents()[source.getX()-2][source.getY()] instanceof EmptySlotComponent){
                            list.add(destination);
                        }
                    }
                    if (source.getY()==destination.getY()&&source.getX()-1==destination.getX()&&
                            ConcreteChessGame.getChessComponents()[destination.getX()][destination.getY()] instanceof EmptySlotComponent){
                        list.add(destination);
                    }
                    if (source.getY()==destination.getY()+1&&source.getX()-1==destination.getX()&&
                            ConcreteChessGame.getChessComponents()[destination.getX()][destination.getY()].getChessColor() ==ChessColor.WHITE){
                        list.add(destination);
                    }
                    if (source.getY()==destination.getY()-1&&source.getX()-1==destination.getX()&&
                            ConcreteChessGame.getChessComponents()[destination.getX()][destination.getY()].getChessColor() ==ChessColor.WHITE){
                        list.add(destination);
                    }
                }
            }
        }
        return list;
    }
}
