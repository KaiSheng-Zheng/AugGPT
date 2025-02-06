import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
       List<ChessboardPoint> cn = new ArrayList<>();

           if(AvailableMove(-1,2)) {
               cn.add(super.getSource().offset(-1, 2));
           }
           if(AvailableMove(1,2)){
               cn.add(super.getSource().offset(1, 2));
           }


            if(AvailableMove(-1,-2)) {
                cn.add(super.getSource().offset(-1, -2));
            }
            if(AvailableMove(1,-2)){
                cn.add(super.getSource().offset(1, -2));
            }


            if(AvailableMove(2,-1)) {
                cn.add(super.getSource().offset(2, -1));
            }
            if(AvailableMove(2,1)){
                cn.add(super.getSource().offset(2, 1));
            }

            if(AvailableMove(-2,-1)) {
                cn.add(super.getSource().offset(-2, -1));
            }
            if(AvailableMove(-2,1)){
                cn.add(super.getSource().offset(-2, 1));
            }

        return cn;
    }
    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source, chessColor);
        if(chessColor == ChessColor.BLACK) {
            name = 'N';
        }
        else
            name = 'n';
    }
}
