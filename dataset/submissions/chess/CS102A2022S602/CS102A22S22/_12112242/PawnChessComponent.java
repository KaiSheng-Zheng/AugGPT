import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {

    public PawnChessComponent(ChessComponent[][]chessComponents, ChessboardPoint source){
       this.chessComponents=chessComponents;
       this.source=source;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x= source.getX();
        int y= source.getY();
        List<ChessboardPoint>chessboardPointList=new ArrayList<>();
        ChessboardPoint chessboardPoint=new ChessboardPoint(x,y);
        if (this.chessColor== ChessColor.WHITE) {

            if (chessboardPoint.offset(-1, 0) != null && chessComponents[x - 1][y] instanceof EmptySlotComponent) {

                if (x == 6) {
                    chessboardPointList.add(new ChessboardPoint(x - 1, y));
                    if (chessComponents[x - 2][y] instanceof EmptySlotComponent) {
                        chessboardPointList.add(new ChessboardPoint(x - 2, y));
                    }
                    if (chessboardPoint.offset(-1, -1) != null && chessComponents[x - 1][y - 1].chessColor == ChessColor.BLACK) {
                        chessboardPointList.add(chessboardPoint.offset(-1, -1));
                    }
                    if (chessboardPoint.offset(-1, 1) != null && chessComponents[x - 1][y + 1].chessColor == ChessColor.BLACK) {
                        chessboardPointList.add(new ChessboardPoint(x - 1, y + 1));
                    }
                } else {
                    chessboardPointList.add(new ChessboardPoint(x - 1, y));
                    if (chessboardPoint.offset(-1, -1) != null && chessComponents[x - 1][y - 1].chessColor == ChessColor.BLACK) {
                        chessboardPointList.add(chessboardPoint.offset(-1, -1));
                    }
                    if (chessboardPoint.offset(-1, 1) != null && chessComponents[x - 1][y + 1].chessColor == ChessColor.BLACK) {
                        chessboardPointList.add(new ChessboardPoint(x - 1, y + 1));
                    }
                }


            }else {
                return new ArrayList<>();
            }
        }
        else if (this.chessColor == ChessColor.BLACK) {

            if (chessboardPoint.offset(1, 0) != null && chessComponents[x + 1][y] instanceof EmptySlotComponent) {

                if (x == 1) {
                    chessboardPointList.add(new ChessboardPoint(x + 1, y));
                    if (chessComponents[x + 2][y] instanceof EmptySlotComponent) {
                        chessboardPointList.add(new ChessboardPoint(x + 2, y));
                    }
                    if (chessboardPoint.offset(1, 1) != null && chessComponents[x + 1][y + 1].chessColor == ChessColor.WHITE) {
                        chessboardPointList.add(chessboardPoint.offset(1, 1));
                    }
                    if (chessboardPoint.offset(1, -1) != null && chessComponents[x + 1][y - 1].chessColor == ChessColor.WHITE) {
                        chessboardPointList.add(new ChessboardPoint(x + 1, y - 1));
                    }
                } else {
                    chessboardPointList.add(new ChessboardPoint(x + 1, y));
                    if (chessboardPoint.offset(1, 1) != null && chessComponents[x + 1][y + 1].chessColor == ChessColor.WHITE) {
                        chessboardPointList.add(chessboardPoint.offset(1, 1));
                    }
                    if (chessboardPoint.offset(1, -1) != null && chessComponents[x + 1][y - 1].chessColor == ChessColor.WHITE) {
                        chessboardPointList.add(new ChessboardPoint(x + 1, y - 1));
                    }
                }


            } else {
                return new ArrayList<>();
            }
        }
        return chessboardPointList;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
