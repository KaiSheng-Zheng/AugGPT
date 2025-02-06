import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

    public KingChessComponent(ChessboardPoint chessboardPoint,ChessColor color,char name) {
       super(chessboardPoint,color,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> list = new ArrayList<>();
        ChessboardPoint source = getSource();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                ChessboardPoint destination = ConcreteChessGame.getChessComponents()[i][j].getSource();
                if (ConcreteChessGame.ChessComponents[i][j].getChessColor()!=getChessColor()){
                    if (destination.getX()==source.getX()+1&&destination.getY()==source.getY()+1){
                    list.add(destination);
                }
                else if (destination.getX()==source.getX()+1&&destination.getY()==source.getY()){
                    list.add(destination);
                }
                else if (destination.getX()==source.getX()+1&&destination.getY()==source.getY()-1){
                    list.add(destination);
                }
                else if (destination.getX()==source.getX()&&destination.getY()==source.getY()+1){
                    list.add(destination);
                }
                else if (destination.getX()==source.getX()&&destination.getY()==source.getY()-1){
                    list.add(destination);
                }
                else if (destination.getX()==source.getX()-1&&destination.getY()==source.getY()+1){
                    list.add(destination);
                }
                else if (destination.getX()==source.getX()-1&&destination.getY()==source.getY()){
                    list.add(destination);
                }
                else if (destination.getX()==source.getX()-1&&destination.getY()==source.getY()-1){
                    list.add(destination);
                }
                }

            }
        }
        return list;
    }
}
