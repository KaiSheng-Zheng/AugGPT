import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint chessboardPoint,ChessColor chesscolor,char name){
        super(chessboardPoint,chesscolor,name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> h=new ArrayList<>();
        ChessboardPoint source=getChessboardPoint();
        for (int i=0;i<8;i++){
            for(int j=0;j<8;j++) {
                boolean x=true;
                ChessboardPoint dest = ConcreteChessGame.getChessComponents()[i][j].getChessboardPoint();
                if (source.getX() == dest.getX()) {
                    if(ConcreteChessGame.getChessComponents()[i][j].getChessColor()!=getChessColor()) {
                        int row = source.getX();
                        for (int col = Math.min(source.getY(), dest.getY()) + 1;
                             col < Math.max(source.getY(), dest.getY()); col++) {
                            if (!(ConcreteChessGame.getChessComponents()[row][col] instanceof EmptySlotComponent)) {
                                x = false;
                            }
                        }
                        if (x) {
                            h.add(dest);
                        }
                    }
                } else if (source.getY() == dest.getY()) {
                    if(ConcreteChessGame.getChessComponents()[i][j].getChessColor()!=getChessColor()) {
                        int col=source.getY();
                        for (int row = Math.min(source.getX(), dest.getX()) + 1;
                             row < Math.max(source.getX(), dest.getX()); row++) {
                            if (!(ConcreteChessGame.getChessComponents()[row][col] instanceof EmptySlotComponent)) {
                                x=false;
                            }
                        }
                        if(x){
                            h.add(dest);
                        }
                    }
                }


            }
        }
        return h;
    }
}
