import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class KingChessComponent extends ChessComponent{


    KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {

        ArrayList<ChessboardPoint> res = new ArrayList<>();
        int x = getBoardPoint().getX();
        int y = getBoardPoint().getY();

        if(y - 1 >= 0){
            res.add(new ChessboardPoint(x, y - 1));
        }
        if(y - 1 >= 0 && x - 1 >= 0){
            res.add(new ChessboardPoint(x - 1, y - 1));
        }
        if(y - 1 >= 0 && x + 1 < 8){
            res.add(new ChessboardPoint(x + 1, y - 1));
        }
        if(x - 1 >= 0){
            res.add(new ChessboardPoint(x - 1, y));
        }
        if(x + 1 < 8){
            res.add(new ChessboardPoint(x + 1, y));
        }
        if(y + 1 < 8){
            res.add(new ChessboardPoint(x, y + 1));
        }
        if(x - 1 >= 0 && y + 1 < 8){
            res.add(new ChessboardPoint(x - 1, y + 1));
        }
        if(x + 1 < 8 && y + 1 < 8){
            res.add(new ChessboardPoint(x + 1, y + 1));
        }

        return res;
    }
}
