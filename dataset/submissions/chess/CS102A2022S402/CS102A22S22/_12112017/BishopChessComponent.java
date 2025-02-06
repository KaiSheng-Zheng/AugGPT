import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{


    public BishopChessComponent(ChessboardPoint chessboardPoint, ChessColor color, char name) {
        super(chessboardPoint, color, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> list  = new ArrayList<>();

        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                ChessboardPoint source = getSource();
                ChessboardPoint destination = ConcreteChessGame.getChessComponents()[i][j].getSource();
                boolean determination = true;
                if (ConcreteChessGame.ChessComponents[i][j].getChessColor()!=getChessColor()){
                    if (source.getX()+source.getY()==destination.getX()+destination.getY()){

                    int he=source.getX()+source.getY();
                    for (int x=Math.min(source.getX(),destination.getX())+1;x<Math.max(source.getX(),destination.getX());x++){
                        if (!(ConcreteChessGame.getChessComponents()[x][he-x] instanceof EmptySlotComponent)){
                            determination = false;
                        }
                    }
                    if (determination)
                        list.add(destination);
                }
                if (source.getX()-source.getY()==destination.getX()-destination.getY()){
                    determination = true;
                    int he=source.getX()-source.getY();;
                    for (int x=Math.min(source.getX(),destination.getX())+1;x<Math.max(source.getX(),destination.getX());x++){
                        if (!(ConcreteChessGame.getChessComponents()[x][x-he] instanceof EmptySlotComponent)){
                            determination=false;
                        }
                    }
                    if (determination)
                        list.add(destination);
                }


                }


            }
        }
        return list;
    }
}
