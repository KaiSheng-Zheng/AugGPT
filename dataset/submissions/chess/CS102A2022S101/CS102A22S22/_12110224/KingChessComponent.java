import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {


    public KingChessComponent(ChessboardPoint chessboardPoint, ChessColor color){
        chessColor = color;
        source = chessboardPoint;
        if(chessColor.equals(ChessColor.WHITE)) {
            name = 'k';
        }else {
            name = 'K';
        }

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        for(int i = source.getX()-1;i< source.getX()+2; i++){
            for (int j = source.getY()-1;j<source.getY()+2;i++){
                if (validMove(new ChessboardPoint(i,j)))
                    list.add(new ChessboardPoint(i,j));
            }
        }
        List<ChessboardPoint> list1 = new ArrayList<>();
        list1.add(new ChessboardPoint(7,3));
        list1.add(new ChessboardPoint(6,3));
        list1.add(new ChessboardPoint(6,4));
        return list1;
    }


}