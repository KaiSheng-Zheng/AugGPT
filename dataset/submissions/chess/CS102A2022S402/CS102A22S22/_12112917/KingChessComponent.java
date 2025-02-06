import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ck = new ArrayList<>();
        for(int i = -1;i<2;i++){
            for(int j = -1;j<2;j++){
                if(i==0&&j==0) continue;
                ChessboardPoint c1 = super.getSource().offset(i,j);
                if(AvailableMove(i,j)&&!InAttackPlaces().containsKey(c1)){
                    ck.add(c1);
                }

            }
        }
        return ck;
    }
    public KingChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source, chessColor);
        if(chessColor == ChessColor.BLACK) {
            name = 'K';
        }
        else
            name = 'k';
    }
}
