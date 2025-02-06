import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor,char name) {
        this.name=name;
        this.setSource(source);
        this.setChessColor(chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> bishopsteps = new ArrayList<>();
        ChessboardPoint bishop=new ChessboardPoint(getSource().getX(), getSource().getY());
        for (int i = -7; i < 8 ; i++) {
            if (bishop.offset(bishop.getX()+i, bishop.getY()+i )!=null){
                bishopsteps.add(bishop.offset(bishop.getX()+i, bishop.getY()+i ));
            }
            if (bishop.offset(bishop.getX()+i, bishop.getY()-i )!=null){
                bishopsteps.add(bishop.offset(bishop.getX()+i, bishop.getY()-i ));
            }
        }
        return bishopsteps;
    }


}
