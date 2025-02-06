import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> destinations = new ArrayList<>();
        ChessboardPoint source = this.getSource();

        for(int i = source.getY()-1; i >= 0; i--){
            if(chessComponents[source.getX()][i].getChessColor() != this.getChessColor()){
                destinations.add(new ChessboardPoint(source.getX(), i));
                if(chessComponents[source.getX()][i].getChessColor() != ChessColor.NONE){
                    break;
                }
            }else break;
        }
        for(int i = source.getY()+1; i <= 7; i++){
            if(chessComponents[source.getX()][i].getChessColor() != this.getChessColor()){
                destinations.add(new ChessboardPoint(source.getX(), i));
                if(chessComponents[source.getX()][i].getChessColor() != ChessColor.NONE){
                    break;
                }
            }else break;
        }

        for(int i = source.getX()-1; i >= 0; i--){
            if(chessComponents[i][source.getY()].getChessColor() != this.getChessColor()){
                destinations.add(new ChessboardPoint(i, source.getY()));
                if(chessComponents[i][source.getY()].getChessColor() != ChessColor.NONE){
                    break;
                }
            }else break;
        }
        for(int i = source.getX()+1;i <= 7; i++){
            if(chessComponents[i][source.getY()].getChessColor() != this.getChessColor()){
                destinations.add(new ChessboardPoint(i, source.getY()));
                if(chessComponents[i][source.getY()].getChessColor() != ChessColor.NONE){
                    break;
                }
            }else break;
        }

        return destinations;
    }
}
