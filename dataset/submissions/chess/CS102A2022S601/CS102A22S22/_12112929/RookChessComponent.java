import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessboardPoint chessboardPoint;
    ChessComponent[][]chessComponents;
    ChessColor chessColor;
    public RookChessComponent(ChessColor chessColor, ChessboardPoint chessboardPoint, ChessComponent[][] chessComponents) {
        //super(chessColor);
        this.chessboardPoint = chessboardPoint;
this.chessComponents=chessComponents;
        this.chessColor=chessColor;
        if(chessColor==ChessColor.BLACK)
            name='R';
        if(chessColor==ChessColor.WHITE)
            name='r';
        setSource(chessboardPoint);
        setChessColor(chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        for (int i = chessboardPoint.getX() - 1; i >= 0; i--) {
            if ((chessComponents[i][chessboardPoint.getY()] instanceof EmptySlotComponent)) {
                ChessboardPoint c = new ChessboardPoint(i, chessboardPoint.getY());

            }
            if (!(chessComponents[i][chessboardPoint.getY()] instanceof EmptySlotComponent) || i == 0) {
                ChessboardPoint c = new ChessboardPoint(i, chessboardPoint.getY());
                if ((chessComponents[i][chessboardPoint.getY()].getChessColor() != chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor())) {
                    for (int j = i; j < chessboardPoint.getX(); j++) {
                        list.add(new ChessboardPoint(j, chessboardPoint.getY()));
                    }
                }
                break;
            }
        }
        for (int i = chessboardPoint.getX() + 1; i < 8; i++) {
            if ((chessComponents[i][chessboardPoint.getY()] instanceof EmptySlotComponent)) {
                ChessboardPoint c = new ChessboardPoint(i, chessboardPoint.getY());
                list.add(c);
            }
            if (!(chessComponents[i][chessboardPoint.getY()] instanceof EmptySlotComponent)) {
                ChessboardPoint c = new ChessboardPoint(i, chessboardPoint.getY());
                if ((chessComponents[i][chessboardPoint.getY()].getChessColor() != chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor())) {
                    list.add(c);
                }
                break;
            }
        }
        for (int i = chessboardPoint.getY() - 1; i >= 0; i--) {
            if ((chessComponents[chessboardPoint.getX()][i] instanceof EmptySlotComponent)) {
                ChessboardPoint c = new ChessboardPoint(chessboardPoint.getX(), i);
            }
            if (!(chessComponents[chessboardPoint.getX()][i] instanceof EmptySlotComponent) || i == 0) {
                ChessboardPoint c = new ChessboardPoint(chessboardPoint.getX(), i);
                if ((chessComponents[chessboardPoint.getX()][i].getChessColor() != chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor())) {
                    for (int j = i; j < chessboardPoint.getY(); j++) {
                        list.add(new ChessboardPoint(chessboardPoint.getX(), j));
                    }
                }
                break;
            }
        }
        for (int i = chessboardPoint.getY() + 1; i < 8; i++) {
            if ((chessComponents[chessboardPoint.getX()][i] instanceof EmptySlotComponent)) {
                ChessboardPoint c = new ChessboardPoint(chessboardPoint.getX(), i);
                list.add(c);
            }
            if (!(chessComponents[chessboardPoint.getX()][i] instanceof EmptySlotComponent)) {
                ChessboardPoint c = new ChessboardPoint(chessboardPoint.getX(), i);
                if ((chessComponents[chessboardPoint.getX()][i].getChessColor() != chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor())) {
                    list.add(c);
                }
                break;
            }
        }

        return list;

    }
}
