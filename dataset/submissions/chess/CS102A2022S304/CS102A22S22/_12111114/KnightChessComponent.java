import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KnightChessComponent  extends ChessComponent{
    public KnightChessComponent(ChessColor chessColor,int x,int y) {
        super();
        setX(x);
        setY(y);
        setChessColor(chessColor);
        name=tochar();
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> a = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            int setX = getX() -2;
            int setY = getY() - 1 ;
            if (setX >= 0 && setY >= 0) {
                char b = StoreChessGame.getConcreteChessGame().getChess(setX, setY).tochar();
                ChessColor c = StoreChessGame.getConcreteChessGame().getChess(setX, setY).getChessColor();
                if (b == '_') {
                    a.add(new ChessboardPoint(setX, setY));
                } else if (c != getChessColor()) {
                    a.add(new ChessboardPoint(setX, setY));
                    break;
                } else {
                    break;
                }
            }
        }//-2-1
        for (int i = 0; i < 1; i++) {
            int setX = getX() -1;
            int setY = getY() - 2 ;
            if (setX >= 0 && setY >= 0) {
                char b = StoreChessGame.getConcreteChessGame().getChess(setX, setY).tochar();
                ChessColor c = StoreChessGame.getConcreteChessGame().getChess(setX, setY).getChessColor();
                if (b == '_') {
                    a.add(new ChessboardPoint(setX, setY));
                } else if (c != getChessColor()) {
                    a.add(new ChessboardPoint(setX, setY));
                    break;
                } else {
                    break;
                }
            }
        }//-1-2
        for (int i = 0; i < 1; i++) {
            int setX = getX() +2;
            int setY = getY() +1;
            if (setX < 8 && setY < 8) {
                char b = StoreChessGame.getConcreteChessGame().getChess(setX, setY).tochar();
                ChessColor c = StoreChessGame.getConcreteChessGame().getChess(setX, setY).getChessColor();
                if (b == '_') {
                    a.add(new ChessboardPoint(setX, setY));
                } else if (c != getChessColor()) {
                    a.add(new ChessboardPoint(setX, setY));
                    break;
                } else {
                    break;
                }
            }
        }//+2+1
        for (int i = 0; i < 1; i++) {
            int setX = getX() +1;
            int setY = getY() +2;
            if (setX < 8 && setY < 8) {
                char b = StoreChessGame.getConcreteChessGame().getChess(setX, setY).tochar();
                ChessColor c = StoreChessGame.getConcreteChessGame().getChess(setX, setY).getChessColor();
                if (b == '_') {
                    a.add(new ChessboardPoint(setX, setY));
                } else if (c != getChessColor()) {
                    a.add(new ChessboardPoint(setX, setY));
                    break;
                } else {
                    break;
                }
            }
        }//+1+2
        for (int i = 0; i < 1; i++) {
            int setX = getX() -1;
            int setY = getY() +2;
            if (setX >= 0 &&setY < 8 ) {
                char b = StoreChessGame.getConcreteChessGame().getChess(setX, setY).tochar();
                ChessColor c = StoreChessGame.getConcreteChessGame().getChess(setX, setY).getChessColor();
                if (b == '_') {
                    a.add(new ChessboardPoint(setX, setY));
                } else if (c != getChessColor()) {
                    a.add(new ChessboardPoint(setX, setY));
                    break;
                } else {
                    break;
                }
            }
        }//-1+2
        for (int i = 0; i < 1; i++) {
            int setX = getX() -2;
            int setY = getY() +1;
            if (setX >= 0 &&setY < 8 ) {
                char b = StoreChessGame.getConcreteChessGame().getChess(setX, setY).tochar();
                ChessColor c = StoreChessGame.getConcreteChessGame().getChess(setX, setY).getChessColor();
                if (b == '_') {
                    a.add(new ChessboardPoint(setX, setY));
                } else if (c != getChessColor()) {
                    a.add(new ChessboardPoint(setX, setY));
                    break;
                } else {
                    break;
                }
            }
        }//-2+1
        for (int i = 0; i < 1; i++) {
            int setX = getX() +1;
            int setY = getY() -2;
            if (setX< 8  && setY >= 0) {
                char b = StoreChessGame.getConcreteChessGame().getChess(setX, setY).tochar();
                ChessColor c = StoreChessGame.getConcreteChessGame().getChess(setX, setY).getChessColor();
                if (b == '_') {
                    a.add(new ChessboardPoint(setX, setY));
                } else if (c != getChessColor()) {
                    a.add(new ChessboardPoint(setX, setY));
                    break;
                } else {
                    break;
                }
            }
        }//+1-2
        for (int i = 0; i < 1; i++) {
            int setX = getX() +2;
            int setY = getY() -1;
            if (setX < 8 && setY >= 0) {
                char b = StoreChessGame.getConcreteChessGame().getChess(setX, setY).tochar();
                ChessColor c = StoreChessGame.getConcreteChessGame().getChess(setX, setY).getChessColor();
                if (b == '_') {
                    a.add(new ChessboardPoint(setX, setY));
                } else if (c != getChessColor()) {
                    a.add(new ChessboardPoint(setX, setY));
                    break;
                } else {
                    break;
                }
            }
        }//+2-1
        a.sort(new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if (o1.getX() > o2.getX()) {
                    return 1;
                } else if (o1.getX() < o2.getX()) {
                    return -1;
                } else {
                    if (o1.getY() > o2.getY())
                        return 1;
                    else return -1;
                }
            }
        });
        return a;
    }

    public char tochar() {
        if(getChessColor().equals(ChessColor.BLACK))
            return 'N';
        else
            return 'n';
    }
    public int getType(){
        return 1;
    }
}
