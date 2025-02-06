import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint chessboardPoint,ChessColor chesscolor,char name){
        super(chessboardPoint,chesscolor,name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> h=new ArrayList<>();
        ChessboardPoint source=getChessboardPoint();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++) {
                ChessboardPoint dest = ConcreteChessGame.getChessComponents()[i][j].getChessboardPoint();
                if (ConcreteChessGame.getChessComponents()[i][j].getChessColor() != getChessColor()) {
                    if (dest.getX() == source.getX() - 2 && dest.getY() == source.getY() - 1) {
                        h.add(dest);
                    } else if (dest.getX() == source.getX() - 2 && dest.getY() == source.getY() + 1) {
                        h.add(dest);
                    } else if (dest.getX() == source.getX() + 2 && dest.getY() == source.getY() - 1) {
                        h.add(dest);
                    } else if (dest.getX() == source.getX() + 2 && dest.getY() == source.getY() + 1) {
                        h.add(dest);
                    } else if (dest.getX() == source.getX() + 1 && dest.getY() == source.getY() - 2) {
                        h.add(dest);
                    } else if (dest.getX() == source.getX() + 1 && dest.getY() == source.getY() + 2) {
                        h.add(dest);
                    } else if (dest.getX() == source.getX() - 1 && dest.getY() == source.getY() - 2) {
                        h.add(dest);
                    } else if (dest.getX() == source.getX() - 1 && dest.getY() == source.getY() + 2) {
                        h.add(dest);
                    }
                }
            }
        }
        return h;
    }
}
