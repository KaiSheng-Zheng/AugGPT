import java.util.ArrayList;
import java.util.List;
public class RookChessComponent extends ChessComponent{

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        setSource(source);
        setChessColor(chessColor);
        super.name = name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> way = new ArrayList<>();
       int s = 0;
        for(int i = -1; i < 2; i += 2){
            int a = i;
            while(getSource().offset(s,i) != null) {
                ChessboardPoint p = getSource().offset(s, i);
                if(super.getChessboard().getChess(p.getX(), p.getY()).getChessColor() == ChessColor.NONE){
                    way.add(p);
                    i += a;
                }
                else if(super.getChessboard().getChess(p.getX(), p.getY()).getChessColor() == getChessColor()){
                    i = a;
                    break;
                }
                else{
                    way.add(p);
                    i = a;
                    break;
                }
            }
            i = a;
            while(getSource().offset(i,s) != null) {
                ChessboardPoint p = getSource().offset(i, s);
                if(super.getChessboard().getChess(p.getX(), p.getY()).getChessColor() == ChessColor.NONE){
                    way.add(p);
                    i += a;
                }
                else if(super.getChessboard().getChess(p.getX(), p.getY()).getChessColor() == getChessColor()){
                    i = a;
                    break;
                }
                else{
                    way.add(p);
                    i = a;
                    break;
                }
            }
            i = a;
        }
        return way;
    }
}
