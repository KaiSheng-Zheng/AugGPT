import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint chessboardPoint,ChessColor chesscolor,char name){
        super(chessboardPoint,chesscolor,name);
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> h=new ArrayList<>();
        ChessboardPoint source=getChessboardPoint();
        for (int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                ChessboardPoint dest=ConcreteChessGame.getChessComponents()[i][j].getChessboardPoint();
                if(Math.abs(dest.getX()-source.getX())<=1&&Math.abs(dest.getY()-source.getY())<=1){
                    if(ConcreteChessGame.getChessComponents()[i][j].getChessColor()!=getChessColor()){
                            h.add(dest);
                        }

                }
            }
        }
        return h;
    }
}
