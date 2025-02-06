import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessboardPoint chessboardPoint,ChessColor chesscolor,char name){
        super(chessboardPoint,chesscolor,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> h=new ArrayList<>();
        ChessboardPoint source=getChessboardPoint();
        for(int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint dest =  ConcreteChessGame.getChessComponents()[i][j].getChessboardPoint();
                boolean a=true;
                if (source.getX()+source.getY()==dest.getX()+dest.getY()&&ConcreteChessGame.getChessComponents()[i][j].getChessColor()!=getChessColor()){
                    int he=source.getX()+source.getY();
                    for (int x=Math.min(source.getX(),dest.getX())+1;x<Math.max(source.getX(),dest.getX());x++){
                        if (!(ConcreteChessGame.getChessComponents()[x][he-x] instanceof EmptySlotComponent)){
                            a=false;
                        }
                    }
                    if (a){
                        h.add(dest);
                    }
                }
                else if (source.getX()-source.getY()==dest.getX()-dest.getY()&&ConcreteChessGame.getChessComponents()[i][j].getChessColor()!=getChessColor()){
                    int he=source.getX()-source.getY();;
                    for (int x=Math.min(source.getX(),dest.getX())+1;x<Math.max(source.getX(),dest.getX());x++){
                        if (!(ConcreteChessGame.getChessComponents()[x][x-he] instanceof EmptySlotComponent)){
                            a=false;
                        }
                    }
                    if (a){
                        h.add(dest);
                    }
                }


                    }

                }
        return h;



            }
        }


