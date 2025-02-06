import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    /** cons */
    RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> res = new ArrayList<>();
        int x = getBoardPoint().getX();
        int y = getBoardPoint().getY();

        /** const y */
        for(int i = 0; i < 8; i++){
            if(i == x){
                continue;
            }
            res.add(new ChessboardPoint(i, y));
        }
        /** const x */
        for(int j = 0; j < 8; j++){
            if(j == y){
                continue;
            }
            res.add(new ChessboardPoint(x, j));
        }
        return res;
    }
}
