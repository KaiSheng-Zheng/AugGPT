import java.util.ArrayList;
import java.util.List;
public class KnightChessComponent extends ChessComponent{

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        setSource(source);
        setChessColor(chessColor);
        super.name = name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> way = new ArrayList<>();
        for(int i = -1; i < 2; i += 2){
            for(int j = -1; j < 2; j += 2){
                if(getSource().offset(i,j*2) != null){
                    ChessboardPoint p = getSource().offset(i, j*2);
                    if(super.getChessboard().getChess(p.getX(), p.getY()).getChessColor() != getChessColor()){
                        way.add(p);
                    }
                }
                if(getSource().offset(i*2,j) != null){
                    ChessboardPoint p = getSource().offset(i*2, j);
                    if(super.getChessboard().getChess(p.getX(), p.getY()).getChessColor() != getChessColor()){
                        way.add(p);
                    }
                }
            }
        }
        return way;
    }
}
