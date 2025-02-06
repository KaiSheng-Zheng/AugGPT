import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(){}
    public RookChessComponent(ChessboardPoint chessboardPoint,ChessColor color,char name){
        super(chessboardPoint, color,name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint>list=new ArrayList<>();
        ChessboardPoint source = getChessboardPoint();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                ChessboardPoint destination=ConcreteChessGame.getChessComponents()[i][j].getChessboardPoint();
                boolean m=true;
                if (source.getX() == destination.getX()&&ConcreteChessGame.getChessComponents()[i][j].getChessColor()!=getChessColor()) {
                    int row = source.getX();
                    for (int col = Math.min(source.getY(), destination.getY()) + 1;
                         col < Math.max(source.getY(), destination.getY()); col++) {
                        if (!(ConcreteChessGame.getChessComponents()[row][col] instanceof EmptySlotComponent)) {
                            m=false;
                        }
                    }
                    if (m){
                        list.add(destination);
                    }
                }
                else if (source.getY() == destination.getY()&&ConcreteChessGame.getChessComponents()[i][j].getChessColor()!=getChessColor()) {
                    int col = source.getY();
                    for (int row = Math.min(source.getX(), destination.getX()) + 1;
                         row < Math.max(source.getX(), destination.getX()); row++) {
                        if (!(ConcreteChessGame.getChessComponents()[row][col] instanceof EmptySlotComponent)) {
                            m=false;
                        }
                    }
                    if (m){
                        list.add(destination);
                    }
                }
            }
        }
        return list;
    }
}
