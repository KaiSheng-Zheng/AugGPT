import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(char name,ChessColor chessColor,ChessboardPoint source,ChessComponent[][] chessComponents){
        super(name,chessColor,source,chessComponents);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (getSource().offset(i, j) == null)
                        continue;
                    else {
                        if (chessComponents[getSource().getX() + i][getSource().getY() + j].getChessColor() == getChessColor())
                            continue;
                        else
                            list.add(getSource().offset(i, j));
                    }
                }
            }
        Collections.sort(list,super.priSort);
            return list;
    }
}

