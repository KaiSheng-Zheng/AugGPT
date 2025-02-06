import java.util.List;

public class KnightChessComponent extends ChessComponent{


    public KnightChessComponent() {
    }

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessboard) {
        super(source, chessColor, name, chessboard);
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {

        //clear in a strange way
        list.clear();
        //fix here if necessary

        ChessboardPoint source=getSource();
        int x=source.getX();
        int y=source.getY();

        examine(x+2,y+1);
        examine(x-2,y+1);
        examine(x+2,y-1);
        examine(x-2,y-1);
        examine(x+1,y+2);
        examine(x-1,y+2);
        examine(x+1,y-2);
        examine(x-1,y-2);
        return list;

    }
    public boolean canMoveTo(ChessboardPoint target) {
        List<ChessboardPoint> chessboardPoints = canMoveTo();
        for (ChessboardPoint chessboardPoint : chessboardPoints) {
            if (target.getX() == chessboardPoint.getX() && target.getY() == chessboardPoint.getY()) return true;
        }
        return false;
    }
}
