import java.util.ArrayList;
import java.util.List;
public class KingChessComponent extends ChessComponent{

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        setSource(source);
        setChessColor(chessColor);
        super.name = name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> way = new ArrayList<>();
        for(int i = -1; i < 2; i++){
            for(int j = -1; j < 2; j++){
                ChessboardPoint p = getSource().offset(i, j);
                if(p != null){
                    if(super.getChessboard().getChess(p.getX(), p.getY()).getChessColor() != getChessColor())
                        way.add(p);
                }
            }
        }
        return way;
    }

}
