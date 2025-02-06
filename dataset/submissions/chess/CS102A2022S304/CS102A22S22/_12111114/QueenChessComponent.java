import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QueenChessComponent  extends ChessComponent{
    public QueenChessComponent(ChessColor chessColor,int x,int y) {
        super();
        setX(x);
        setY(y);
        setChessColor(chessColor);
        name=tochar();
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> a = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int setX = getX() - 1 - i;
            int setY = getY() - 1 - i;
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
        }
        for (int i = 0; i < 8; i++) {
            int setX = getX() + 1 + i;
            int setY = getY() + 1 + i;
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
        }
        for (int i = 0; i < 8; i++) {
            int setX = getX() - 1 - i;
            int setY = getY() + 1 + i;
            if (setY < 8 && setX >= 0) {
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
        }
        for (int i = 0; i < 8; i++) {
            int setX = getX() + 1 + i;
            int setY = getY() - 1 - i;
            if (setY >= 0 && setX < 8) {
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
        }
        for (int i = 0; i < 8; i++) {
            int setX = getX() - 1 - i;
            int setY = getY();
            if (setX >= 0) {
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
        }
        for (int i = 0; i < 8; i++) {
            int setX = getX() + 1 + i;
            int setY = getY();
            if (setX<8) {
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
        }
        for (int i = 0; i < 8; i++) {
            int setX = getX();
            int setY = getY() + 1 + i;
            if (setY <8) {
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
        }
        for (int i = 0; i < 8; i++) {
            int setX = getX();
            int setY = getY() - 1 - i;
            if (setY>= 0) {
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
        }
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
            return 'Q';
        else
            return 'q';
    }
    public int getType(){
        return 3;
    }
}
