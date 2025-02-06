import java.util.ArrayList;
import java.util.List;
public class BishopChessComponent extends ChessComponent{

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        setSource(source);
        setChessColor(chessColor);
        super.name = name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> way = new ArrayList<>();
        for(int i = -1; i < 2; i++){
            for(int j = -1; j < 2; j++){
                if(i == 0) i++;
                if(j == 0) j++;
                int a = i; int b = j;
                while(getSource().offset(i,j) != null){
                    ChessboardPoint p = getSource().offset(i, j);
                    if(super.getChessboard().getChess(p.getX(), p.getY()).getChessColor() == ChessColor.NONE){
                        way.add(p);
                        i += a;j += b;
                    }
                    else if(super.getChessboard().getChess(p.getX(), p.getY()).getChessColor() == getChessColor()){
                        i = a; j = b;
                        break;
                    }
                    else{
                        way.add(p);
                        i = a; j = b;
                        break;
                    }
                }
                i = a; j = b;
            }
        }
        return way;
    }
}
