import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
//    private ChessboardPoint source;



    protected ChessComponent[][] chessboard;
    int number=0;
    public PawnChessComponent(ChessComponent[][] chessboard,ChessboardPoint source,char name) {
        super(chessboard,source,name);
        this.chessboard=chessboard;
//        this.source=source;
        setSource(source);
        this.name=name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source=getSource();
        int x=getSource().getX();
        int y=getSource().getY();
        ArrayList arrayList=new ArrayList<>();
        if(number==0) {

            if(getChessColor().equals(ChessColor.BLACK)) {
                if(checkPosition(x+2,y)) {
                    if (chessboard[x + 1][y] instanceof EmptySlotComponent) {
                        if (chessboard[x + 2][y] instanceof EmptySlotComponent) {
                            arrayList.add(source.offset( 2, 0));
                        }
                    }
                }
            }else{
                if(checkPosition(x-2,y)) {
                    if (chessboard[x - 1][y] instanceof EmptySlotComponent) {
                        if (chessboard[x - 2][y] instanceof EmptySlotComponent) {
                            arrayList.add(source.offset( - 2, 0));
                        }
                    }
                }

            }
        }
            if (getChessColor().equals(ChessColor.BLACK)) {
                if (checkPosition(x + 1, y)) {
                    if (chessboard[x + 1][y] instanceof EmptySlotComponent) {
                        arrayList.add(source.offset(1, 0));
                    }
                }
                if (checkPosition(x + 1, y + 1)) {
                    if (chessboard[x + 1][y + 1] instanceof EmptySlotComponent) {

                    } else {
                        if (!checkColor(chessboard[x + 1][y + 1].getChessColor())) {
                            arrayList.add(source.offset(1, 1));
                        }
                    }
                }
                if (checkPosition(x + 1, y - 1)) {
                    if (chessboard[x + 1][y - 1] instanceof EmptySlotComponent) {

                    } else {
                        if (!checkColor(chessboard[x + 1][y - 1].getChessColor())) {
                            arrayList.add(source.offset(1, -1));
                        }
                    }
                }
            } else {
                if (checkPosition(x - 1, y)) {
                    if (chessboard[x - 1][y] instanceof EmptySlotComponent) {
                        arrayList.add(source.offset(-1, 0));
                    }
                }
                if (checkPosition(x - 1, y + 1)) {
                    if (chessboard[x - 1][y - 1] instanceof EmptySlotComponent) {

                    } else {
                        if (!checkColor(chessboard[x - 1][y + 1].getChessColor())) {
                            arrayList.add(source.offset(-1, 1));
                        }
                    }
                }
                if (checkPosition(x - 1, y - 1)) {
                    if (chessboard[x - 1][y - 1] instanceof EmptySlotComponent) {

                    } else {
                        if (!checkColor(chessboard[x - 1][y - 1].getChessColor())) {
                            arrayList.add(source.offset(-1, -1));
                        }
                    }
                }

        }
        number++;
        return arrayList;
    }
}
