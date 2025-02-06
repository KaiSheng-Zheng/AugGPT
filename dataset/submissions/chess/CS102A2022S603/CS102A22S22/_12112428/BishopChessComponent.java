import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{

    /** cons */
    BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> res = new ArrayList<>();
        int x = getBoardPoint().getX();
        int y = getBoardPoint().getY();
        for(int i = 0; i < 8; i++){
            if(x - i >= 0 && y - i >= 0){
                res.add(new ChessboardPoint(x - i, y - i));
            }
            if(x + i < 8 && y + i < 8){
                res.add(new ChessboardPoint(x + i, y + i));
            }
            if(x - i >= 0 && y + i < 8){
                res.add(new ChessboardPoint(x - i, y + i));
            }
            if(x + 1 < 8 && y - i >= 0){
                res.add(new ChessboardPoint(x + i, y - i));
            }
        }
        return res;
    }
}
