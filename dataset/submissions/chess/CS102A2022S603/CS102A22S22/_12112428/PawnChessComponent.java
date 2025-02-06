import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {

        ArrayList<ChessboardPoint> res = new ArrayList<>();

        int x = getBoardPoint().getX();
        int y = getBoardPoint().getY();

        if(getColor() == ChessColor.BLACK){
            if(x == 1){
                res.add(new ChessboardPoint(x + 1, y));
            }
            if(x + 1 < 8){
                res.add(new ChessboardPoint(x + 1, y));
            }
        }
        else{
            if(x == 6){
                res.add(new ChessboardPoint(x - 1, y));
            }
            if(x - 1 >= 0){
                res.add(new ChessboardPoint(x - 1, y));
            }
        }
        return res;
    }
}
