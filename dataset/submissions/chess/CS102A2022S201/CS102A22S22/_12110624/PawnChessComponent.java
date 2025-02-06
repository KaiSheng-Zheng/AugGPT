import java.util.ArrayList;
import java.util.List;
public class PawnChessComponent extends ChessComponent{

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        setSource(source);
        setChessColor(chessColor);
        super.name = name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> way = new ArrayList<>();
        if(getChessColor() == ChessColor.BLACK){
            for(int i = -1; i < 2; i++){
                if(getSource().offset(1, i) != null){
                    ChessboardPoint p = getSource().offset(1, i);
                    if(i == 0){
                        if(super.getChessboard().getChess(p.getX(), p.getY()).getChessColor() == ChessColor.NONE)
                            way.add(p);
                        if(getSource().getX() == 1){
                            ChessboardPoint q = p.offset(1,0);
                            if(super.getChessboard().getChess(q.getX(), q.getY()).getChessColor() == ChessColor.NONE)
                                way.add(q);
                        }
                    }
                    else{
                        if(super.getChessboard().getChess(p.getX(), p.getY()).getChessColor() == ChessColor.WHITE)
                            way.add(p);
                    }

                }
            }
        }
        if(getChessColor() == ChessColor.WHITE){
            for(int i = -1; i < 2; i++){
                if(getSource().offset(-1, i) != null){
                    ChessboardPoint p = getSource().offset(-1, i);
                    if(i == 0){
                        if(super.getChessboard().getChess(p.getX(), p.getY()).getChessColor() == ChessColor.NONE)
                            way.add(p);
                        if(getSource().getX() == 6){
                            ChessboardPoint q = p.offset(-1,0);
                            if(super.getChessboard().getChess(q.getX(), q.getY()).getChessColor() == ChessColor.NONE)
                                way.add(q);
                        }
                    }
                    else{
                        if(super.getChessboard().getChess(p.getX(), p.getY()).getChessColor() == ChessColor.BLACK)
                            way.add(p);
                    }

                }
            }
        }
        return way;
    }
}
