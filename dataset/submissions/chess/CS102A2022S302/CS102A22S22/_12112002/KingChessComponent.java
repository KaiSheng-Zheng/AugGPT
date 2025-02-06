import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    //changed rudely


    public KingChessComponent() {

    }

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessboard) {
        super(source, chessColor, name, chessboard);
    }

    public boolean canMoveTo(ChessboardPoint target) {
        List<ChessboardPoint> chessboardPoints = canMoveTo();
        for (ChessboardPoint chessboardPoint : chessboardPoints) {
            if (target.getX() == chessboardPoint.getX() && target.getY() == chessboardPoint.getY()) return true;
        }
        return false;
    }

    @Override
    public List<ChessboardPoint> canMoveTo(){

        //clear in a strange way
        list.clear();
        //fix here if necessary

        ChessboardPoint source=getSource();
        int x=source.getX();
        int y=source.getY();

        examine(x+1,y);
        examine(x+1,y+1);
        examine(x+1,y-1);
        examine(x,y-1);
        examine(x,y+1);
        examine(x-1,y-1);
        examine(x-1,y);
        examine(x-1,y+1);





        return list;

    }

    //FIXME:



}
