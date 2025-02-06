import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

    KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> res = new ArrayList<>();
        int x = this.getBoardPoint().getX();
        int y = this.getBoardPoint().getY();

        if(x - 1 >= 0 && x - 1 < 8 && y - 2 >= 0 && y - 2 < 8){
            res.add(new ChessboardPoint(x - 1, y - 2));
        }
        if(x - 1 >= 0 && x - 1 < 8 && y + 2 >= 0 && y + 2 < 8){
            res.add(new ChessboardPoint(x - 1, y + 2));
        }
        if(x + 1 >= 0 && x + 1 < 8 && y - 2 >= 0 && y - 2 < 8){
            res.add(new ChessboardPoint(x + 1, y - 2));
        }
        if(x + 1 >= 0 && x + 1 < 8 && y + 2 >= 0 && y + 2 < 8){
            res.add(new ChessboardPoint(x + 1, y + 2));
        }
        if(x - 2 >= 0 && x - 2 < 8 && y - 1 >= 0 && y - 1 < 8){
            res.add(new ChessboardPoint(x - 2, y - 1));
        }
        if(x - 2 >= 0 && x - 2 < 8 && y + 1 >= 0 && y + 1 < 8){
            res.add(new ChessboardPoint(x - 2, y + 1));
        }
        if(x + 2 >= 0 && x + 2 < 8 && y - 1 >= 0 && y - 1 < 8){
            res.add(new ChessboardPoint(x + 2, y - 1));
        }
        if(x + 2 >= 0 && x + 2 < 8 && y + 1 >= 0 && y + 1 < 8){
            res.add(new ChessboardPoint(x + 2, y + 1));
        }
        return res;
    }
}
