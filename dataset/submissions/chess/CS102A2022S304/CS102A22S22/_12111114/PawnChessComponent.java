import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PawnChessComponent  extends ChessComponent{
    public PawnChessComponent(ChessColor chessColor,int x,int y) {
        super();
        setX(x);
        setY(y);
        setChessColor(chessColor);
        name=tochar();
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> a = new ArrayList<>();
        if(getChessColor()==ChessColor.BLACK){
            char b=StoreChessGame.getConcreteChessGame().getChess(getX()+1, getY()).tochar();
            if (b=='_')
                a.add(new ChessboardPoint(getX()+1, getY()));
            if (getX()==1){
                a.add(new ChessboardPoint(getX()+2, getY()));
            }
            ChessColor c = StoreChessGame.getConcreteChessGame().getChess(getX()+1, getY()-1).getChessColor(); // error if y = 0
            if (c==ChessColor.WHITE){
                a.add(new ChessboardPoint(getX()+1, getY()-1));
            }
            c = StoreChessGame.getConcreteChessGame().getChess(getX()+1, getY()+1).getChessColor();
            if (c==ChessColor.WHITE){
                a.add(new ChessboardPoint(getX()+1, getY()+1));
            }
        }
        else if(getChessColor()==ChessColor.WHITE){
            char b=StoreChessGame.getConcreteChessGame().getChess(getX()-1, getY()).tochar();
            if (b=='_')
                a.add(new ChessboardPoint(getX()-1, getY()));
            if (getX()==6){
                a.add(new ChessboardPoint(getX()-2, getY()));
            }
            ChessColor c = StoreChessGame.getConcreteChessGame().getChess(getX()-1, getY()-1).getChessColor();
            if (c==ChessColor.BLACK){
                a.add(new ChessboardPoint(getX()-1, getY()-1));
            }
            c = StoreChessGame.getConcreteChessGame().getChess(getX()-1, getY()+1).getChessColor();
            if (c==ChessColor.BLACK){
                a.add(new ChessboardPoint(getX()-1, getY()+1));
            }
        }

        a.sort(new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if(o1.getX()>o2.getX()) {
                    return 1;
                }else if(o1.getX()<o2.getX()){
                    return -1;
                }else {
                    if (o1.getY()>o2.getY())
                        return 1;
                    else return -1;
                }
            }});
        return a;
    }

    public char tochar() {
        if(getChessColor().equals(ChessColor.BLACK))
            return 'P';
        else
            return 'p';
    }
    public int getType(){
        return 5;
    }
}
