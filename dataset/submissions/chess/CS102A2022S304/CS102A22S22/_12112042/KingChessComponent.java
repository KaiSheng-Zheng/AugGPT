import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent() {

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        ChessboardPoint source = getSource();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                if (Math.abs(source.getX() - chessboardPoint.getX()) == 1 && source.getY() == chessboardPoint.getY()) {
                    if ((chessboard[i][j] instanceof EmptySlotComponent)) {
                        list.add(chessboardPoint);
                    }else if(!(chessboard[i][j] instanceof EmptySlotComponent) && chessboard[i][j].chessColor != this.chessColor){
                        list.add(chessboardPoint);
                    }
                } else if (Math.abs(source.getY() - chessboardPoint.getY()) == 1 && source.getX() == chessboardPoint.getX()) {
                    if (chessboard[i][j] instanceof EmptySlotComponent) {
                        list.add(chessboardPoint);
                    }else if(!(chessboard[i][j] instanceof EmptySlotComponent) && chessboard[i][j].chessColor != this.chessColor){
                        list.add(chessboardPoint);
                    }
                } else if (Math.abs(source.getX() - chessboardPoint.getX()) == 1 && Math.abs(source.getY() - chessboardPoint.getY()) == 1) {
                    if (chessboard[i][j] instanceof EmptySlotComponent) {
                        list.add(chessboardPoint);
                    }else if(!(chessboard[i][j] instanceof EmptySlotComponent) && chessboard[i][j].chessColor != this.chessColor){
                        list.add(chessboardPoint);
                    }
                }
            }
        }
        if(list.size() == 0){
            return new ArrayList<>();
        }else{
            return list;
        }
    }
}
