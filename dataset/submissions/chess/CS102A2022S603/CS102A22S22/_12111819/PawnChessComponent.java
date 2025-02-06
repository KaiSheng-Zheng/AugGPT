
import java.util.ArrayList;
import java.util.List;


public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(char name, ChessboardPoint source){
        setName(name);
        if(name == 'P'){
            setChessColor(ChessColor.BLACK);
        }else {
            setChessColor(ChessColor.WHITE);
        }
        setSource(source);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> L = new ArrayList<>();
        if(getChessColor()==ChessColor.WHITE && getSource().getX()+1<8){
            L.add(getSource().offset(1,0));
        }else if(getChessColor()==ChessColor.BLACK && getSource().getX()-1>=0){
            L.add(getSource().offset(-1,0));
        }
        return new ArrayList<>();
    }
}
