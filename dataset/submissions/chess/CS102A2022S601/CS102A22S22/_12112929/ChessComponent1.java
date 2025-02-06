import java.util.ArrayList;
import java.util.List;

public class ChessComponent1 extends ChessComponent {
    public ChessComponent1(ChessColor chessColor, ChessboardPoint chessboardPoint, ChessComponent[][] chessComponents) {
//super(chessColor);
        setChessColor(chessColor);
    }

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint>list=new ArrayList<>();
        ChessboardPoint c =null;
        list.add(c);
        return list;
    }
}
